package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.view.FavoritPokemonView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class FavoritPokemonPresenter : MvpPresenter<FavoritPokemonView>() {

    lateinit var router: Router

    lateinit var favoritesPokemonRepo: IFavoritesPokemonsRepo

    var pokemon: Pokemon? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}