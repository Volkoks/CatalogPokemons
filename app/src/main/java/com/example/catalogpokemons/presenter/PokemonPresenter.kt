package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.view.PokemonView
import moxy.MvpPresenter

/**
 * Презентер для фрагмента Покемона ( здесь происходит логика взаимодействия фрагмента и данных)
 */
class PokemonPresenter: MvpPresenter<PokemonView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }
}