package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.Results
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.repository.IPokemonsRepos
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.view.PokemonView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Презентер для фрагмента Покемона ( здесь происходит логика взаимодействия фрагмента и данных)
 */
class PokemonPresenter() : MvpPresenter<PokemonView>() {
    @Inject
    lateinit var pokemonRepo: IPokemonsRepos

    @Inject
    lateinit var favoritesPokemonRepo: IFavoritesPokemonsRepo

    @Inject
    lateinit var mainThread: Scheduler

    @Inject
    lateinit var router: Router

    var result: Results? = null
    var pokemon: Pokemon? = null


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadPokemon()

    }

    fun loadPokemon() {
        pokemonRepo.getPokemon(result?.url.toString()).observeOn(mainThread)
            .subscribe({
                pokemon = it
                viewState.init(it)
                it.sprites?.front_default?.let { it1 -> viewState.loadImage(it1) }
            }, {
                viewState.showError(it)
            })
    }

    fun addPokemonInFavorites() {
        pokemon?.let {
            favoritesPokemonRepo.addPokemon(pokemon).observeOn(mainThread).subscribe()
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}