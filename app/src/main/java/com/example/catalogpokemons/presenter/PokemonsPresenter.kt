package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import com.example.catalogpokemons.data.retrofit.repository.IPokemonRepos
import com.example.catalogpokemons.navigator.Screens
import com.example.catalogpokemons.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.view.PokemonItemView
import com.example.catalogpokemons.view.PokemonsView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class PokemonsPresenter(
    val mainThread: Scheduler,
    val repository: IPokemonRepos,
    val router: Router
) :
    MvpPresenter<PokemonsView>() {

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

    private fun loadData() {
        for (i in 1..1000) {
            repository.getPokemon(i)
                .observeOn(mainThread)
                .subscribe(
                    { pokemon ->
                        listPresenter.pokemons.add(pokemon)
                        listPresenter.pokemons.sortBy { it.id }
                        viewState.updateList()
                    },
                    { error -> viewState.snowError(error) }
                )
        }
    }


    inner class PokemonListPresenter : IPokemonListPresenter {
        var pokemons = mutableListOf<Pokemon>()
        override var itemClickListener: ((PokemonItemView) -> Unit)? = null


        override fun getCount() = pokemons.size

        override fun bind(view: PokemonItemView) {
            val pokemon = pokemons[view.pos]
            pokemon?.let { view.bind(it) }
        }

    }
}