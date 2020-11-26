package com.example.catalogpokemons.data.retrofit.loader

import com.example.catalogpokemons.data.retrofit.api.IPokemonDataSource
import com.example.catalogpokemons.data.retrofit.repository.IPokemonRepos
import io.reactivex.rxjava3.schedulers.Schedulers

class LoaderPokemon(val api: IPokemonDataSource) : IPokemonRepos {
    override fun getPokemon(id: Int) = api.getPokemon(id).subscribeOn(Schedulers.io())
}