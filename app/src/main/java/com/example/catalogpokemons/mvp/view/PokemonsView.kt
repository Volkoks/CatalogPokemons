package com.example.catalogpokemons.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonsView:MvpView {
    fun init()
    fun updateList()
    fun snowError(error:Throwable)
}