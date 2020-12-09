package com.example.catalogpokemons.mvp.view

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon

interface PokemonItemView : IItemView{
    fun bind(pokemon: Pokemon)
    fun loadImg(url:String)
}