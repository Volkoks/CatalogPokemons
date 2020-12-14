package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.navigator.Screens
import com.example.catalogpokemons.mvp.view.MainActivityView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Презентер Активити
 */
class MainActivityPresenter() : MvpPresenter<MainActivityView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.PokemonsScreen())
    }

}