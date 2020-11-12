package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.navigator.Screens
import com.example.catalogpokemons.view.MainActivityView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainActivityPresenter(val router: Router): MvpPresenter<MainActivityView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.PokemonsScreen())
    }
    fun backClicked(){
        router.exit()
    }
}