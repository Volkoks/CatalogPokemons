package com.example.catalogpokemons.mvp.model.retrofit.repository

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.entity.Root
import io.reactivex.rxjava3.core.Single

interface IPokemonsRepos {
    fun getRoot(): Single<Root>
    fun getPokemon(url:String): Single<Pokemon>
    fun getListPokemon():Single<List<Pokemon?>?>
}