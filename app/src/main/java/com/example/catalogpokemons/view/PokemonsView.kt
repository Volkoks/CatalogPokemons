package com.example.catalogpokemons.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonsView:MvpView {
    fun init()
    fun updateList()
}