package com.example.catalogpokemons.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FavoritPokemonView:MvpView {
    fun init()
    fun update()
    fun error(e: String?)
}