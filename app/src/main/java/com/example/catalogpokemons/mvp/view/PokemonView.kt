package com.example.catalogpokemons.mvp.view

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonView:MvpView {
    fun init(pokemon: Pokemon)
    fun loadImage(url:String)
    fun showError(e: Throwable)
}