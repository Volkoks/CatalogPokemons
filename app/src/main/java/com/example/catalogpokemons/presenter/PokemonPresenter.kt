package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.view.PokemonView
import moxy.MvpPresenter

class PokemonPresenter: MvpPresenter<PokemonView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }
}