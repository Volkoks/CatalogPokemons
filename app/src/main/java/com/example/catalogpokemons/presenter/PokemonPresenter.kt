package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import com.example.catalogpokemons.data.retrofit.loader.GlideImgLoader
import com.example.catalogpokemons.view.PokemonView
import moxy.MvpPresenter

/**
 * Презентер для фрагмента Покемона ( здесь происходит логика взаимодействия фрагмента и данных)
 */
class PokemonPresenter() : MvpPresenter<PokemonView>() {

    var pokemon: Pokemon? = null


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        pokemon?.let {
            viewState.init(it)
            it.sprites?.front_default?.let { it1 -> viewState.loadImage(it1) }
        }
    }


}