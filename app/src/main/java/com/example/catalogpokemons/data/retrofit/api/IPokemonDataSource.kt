package com.example.catalogpokemons.data.retrofit.api

import com.example.catalogpokemons.data.retrofit.entity.Results
import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import com.example.catalogpokemons.data.retrofit.entity.Root
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface IPokemonDataSource {
    @GET("pokemon/?limit=155")
    fun getPokemons(): Single<Root>

    @GET
    fun getPokemon(@Url url: String): Single<Pokemon>
}