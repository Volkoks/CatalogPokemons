package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.view.PokemonView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Презентер для фрагмента FavoritPokemonPresenter
 */
class FavoritPokemonPresenter : MvpPresenter<PokemonView>() {

    @Inject
    lateinit var favoritesPokemonRepo: IFavoritesPokemonsRepo

    @Inject
    lateinit var mainThread: Scheduler

    @Inject
    lateinit var router: Router

    var pokemon: Pokemon? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadFovaritesPokemon()
    }

    fun loadFovaritesPokemon() {
        pokemon?.let { viewState.init(it) }
        pokemon?.sprites?.front_default?.let { viewState.loadImage(it) }
    }

    /**
     * Функция удаления из БД Избранных покемонов
     */
    fun deletePokemonFromFavorites() {
        pokemon?.let {
            favoritesPokemonRepo.deletePokemon(it).observeOn(mainThread).subscribe()
        }
    }

    fun backPressed(): Boolean {
        loadFovaritesPokemon()
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.finish()
    }
}