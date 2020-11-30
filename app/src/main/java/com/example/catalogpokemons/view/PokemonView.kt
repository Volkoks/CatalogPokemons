package com.example.catalogpokemons.view

import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonView:MvpView {
    fun init(pokemon:Pokemon)
    fun loadImage(url:String)
}