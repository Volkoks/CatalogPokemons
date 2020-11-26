package com.example.catalogpokemons.data.retrofit.api

import com.example.catalogpokemons.data.retrofit.entity.Pokemon
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonDataSource {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id")id:Int):Observable<Pokemon>

}