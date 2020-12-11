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
            val pokemon = listPresenter.pokemons[it.pos]
            router.navigateTo(Screens.PokemonScreen(pokemon))
        }
    }

    fun replaceToFavoritesPokemonsFragment() {
        router.navigateTo(Screens.FavoritesPokemonsScreen())
    }

    private fun loadData() {
        repository.getListPokemon().observeOn(mainThread).subscribe({
            listPresenter.pokemons.clear()
            listPresenter.pokemons.addAll(it as List<Pokemon>)
            listPresenter.pokemons.sortBy { it.id }
            viewState.updateList()
        }, {
            viewState.snowError(it)

        })
    }


    inner class PokemonListPresenter() :
        IPokemonListPresenter {

        var pokemons = mutableListOf<Pokemon>()
        override var itemClickListener: ((PokemonItemView) -> Unit)? = null


        override fun getCount() = pokemons.size

        override fun bind(view: PokemonItemView) {
            val pokemon = pokemons[view.pos]
            view.bind(pokemon)
            pokemon.sprites?.front_default?.let { view.loadImg(it) }
        }
    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}