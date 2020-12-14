package com.example.catalogpokemons.mvp.view

import com.example.catalogpokemons.mvp.model.retrofit.entity.Results
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon

interface PokemonItemView : IItemView{
    fun initName(result: Results)
    fun bind(pokemon: Pokemon)
    fun loadImg(url:String)
}