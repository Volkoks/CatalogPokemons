package com.example.catalogpokemons.view

import com.example.catalogpokemons.data.entity.Pokemon

interface PokemonItemView : IItemView{
    fun bind(pokemon:Pokemon)
}