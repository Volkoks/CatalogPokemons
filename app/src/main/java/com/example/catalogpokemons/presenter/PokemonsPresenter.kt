package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.data.entity.Pokemon
import com.example.catalogpokemons.data.repository.PokemonRepo
import com.example.catalogpokemons.navigator.Screens
import com.example.catalogpokemons.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.view.PokemonItemView
import com.example.catalogpokemons.view.PokemonsView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class PokemonsPresenter(val repository: PokemonRepo, val router: Router) :
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
        repository.getPokemon()
            .subscribe(
                { listPokemons -> listPresenter.pokemons.addAll(listPokemons) },
                { error -> println("Ошибка: ${error}") }
            )
        viewState.updateList()
    }

    inner class PokemonListPresenter : IPokemonListPresenter {
        var pokemons = mutableListOf<Pokemon>()
        override var itemClickListener: ((PokemonItemView) -> Unit)? = null


        override fun getCount() = pokemons.size

        override fun bind(view: PokemonItemView) {
            val pokemon = pokemons[view.pos]
            view.bind(pokemon)
        }

    }
}