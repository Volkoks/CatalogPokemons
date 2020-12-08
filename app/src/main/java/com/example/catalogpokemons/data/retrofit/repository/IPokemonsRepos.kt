package com.example.catalogpokemons.data.retrofit.repository

import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.data.retrofit.entity.Root
import io.reactivex.rxjava3.core.Single

interface IPokemonsRepos {
    fun getPokemons(): Single<Root>
    fun getPokemon(url:String): Single<Pokemon>
}