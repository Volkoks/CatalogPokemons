package com.example.catalogpokemons.mvp.model.retrofit.api

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.entity.Root
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface IPokemonDataSource {
    @GET("pokemon/?limit=155")
    fun getPokemons(): Single<Root>

    @GET
    fun getPokemon(@Url url: String): Single<Pokemon>
}