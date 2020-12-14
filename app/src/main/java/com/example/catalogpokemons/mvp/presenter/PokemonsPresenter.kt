package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.entity.Results
import com.example.catalogpokemons.mvp.model.retrofit.repository.IPokemonsRepos
import com.example.catalogpokemons.navigator.Screens
import com.example.catalogpokemons.mvp.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.mvp.view.PokemonItemView
import com.example.catalogpokemons.mvp.view.PokemonsView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Презентер фрагмента PokemonsFragment
 */
class PokemonsPresenter() : MvpPresenter<PokemonsView>() {
    @Inject
    lateinit var mainThread: Scheduler

    @Inject
    lateinit var repository: IPokemonsRepos

    @Inject
    lateinit var router: Router

    val listPresenter = PokemonListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        listPresenter.itemClickListener = {
            router.navigateTo(Screens.PokemonScreen(listPresenter.results[it.pos]))
        }
    }

    fun replaceToFavoritesPokemonsFragment() {
        router.navigateTo(Screens.FavoritesPokemonsScreen())
    }

    private fun loadData() {
        repository.getRoot().observeOn(mainThread).subscribe({
            listPresenter.results.clear()
            it.results?.let { it1 -> listPresenter.results.addAll(it1) }
            viewState.updateList()
        }, {
            viewState.snowError(it)
        })
    }


    inner class PokemonListPresenter() :
        IPokemonListPresenter {
        val results = mutableListOf<Results>()
        override var itemClickListener: ((PokemonItemView) -> Unit)? = null


        override fun getCount() = results.size

        override fun bind(view: PokemonItemView) {
            val result = results[view.pos]
            view.initName(result)
            repository.getPokemon(result.url.toString()).observeOn(mainThread)
                .subscribe({ pokemon ->
                    view.bind(pokemon)
                    pokemon.sprites?.front_default?.let { view.loadImg(it) }
                }, {
                    viewState.snowError(it)
                })
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}