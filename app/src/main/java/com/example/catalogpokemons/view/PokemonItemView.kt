package com.example.catalogpokemons.view

import com.example.catalogpokemons.data.retrofit.entity.Pokemon

interface PokemonItemView : IItemView{
    fun bind(pokemon:Pokemon)
    fun loadImg(url:String)
}