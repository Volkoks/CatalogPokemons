package com.example.catalogpokemons.data.retrofit.repository

import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface IPokemonRepos {
    fun getPokemon(id:Int):Single<Pokemon>
}