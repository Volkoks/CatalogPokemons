package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
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
    lateinit var favoritesPokemonRepo: IFavoritesPokemonsRepo

    @Inject
    lateinit var mainThread: Scheduler

    @Inject
    lateinit var router: Router

    var pokemon: Pokemon? = null


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        pokemon?.let {
            viewState.init(it)
            it.sprites?.front_default?.let { it1 -> viewState.loadImage(it1) }
        }
    }

    fun addPokemonInFavorites() {
        pokemon?.let {
            favoritesPokemonRepo.addPokemon(pokemon).observeOn(mainThread).subscribe()
        }
    }

    fun deletePokemonFromFavorites() {
        pokemon?.let {
            favoritesPokemonRepo.deletePOkemon(it).observeOn(mainThread).subscribe()
            backPressed()
        }


    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}