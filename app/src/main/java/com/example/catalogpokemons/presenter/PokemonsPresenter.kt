package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import com.example.catalogpokemons.data.retrofit.entity.Results
import com.example.catalogpokemons.data.retrofit.repository.IPokemonsRepos
import com.example.catalogpokemons.navigator.Screens
import com.example.catalogpokemons.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.view.PokemonItemView
import com.example.catalogpokemons.view.PokemonsView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class PokemonsPresenter(
    val mainThread: Scheduler,
    val repository: IPokemonsRepos,
    val router: Router
) :
    MvpPresenter<PokemonsView>() {

    val listPresenter = PokemonListPresenter(mainThread, repository)
    private var listResult: List<Results>? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        listPresenter.itemClickListener = {
            val pokemon = listPresenter.pokemons[it.pos]
            router.navigateTo(Screens.PokemonScreen(pokemon))
        }
    }

    private fun loadData() {
        repository.getPokemons()
            .subscribe(
                { pokemons ->
                    listResult = pokemons.results
                    listResult?.forEach {
                        it.url?.let { it1 ->
                            repository.getPokemon(it1)
                                .observeOn(mainThread)
                                .subscribe({ pokemon ->
                                    listPresenter.pokemons.add(pokemon)
                                    listPresenter.pokemons.sortBy { it.id }
                                    viewState.updateList()
                                })
                        }
                    }
                },
                { error ->
                    viewState.snowError(error)
                }
            )

    }


    inner class PokemonListPresenter(val mainThread: Scheduler, val repository: IPokemonsRepos) :
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
}