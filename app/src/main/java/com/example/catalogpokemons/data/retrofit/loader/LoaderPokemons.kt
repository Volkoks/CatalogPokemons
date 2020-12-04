package com.example.catalogpokemons.data.retrofit.loader

import com.example.catalogpokemons.data.retrofit.api.IPokemonDataSource
import com.example.catalogpokemons.data.retrofit.entity.Results
import com.example.catalogpokemons.data.retrofit.entity.Root
import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.data.retrofit.repository.IPokemonsRepos
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class LoaderPokemons(val api: IPokemonDataSource) : IPokemonsRepos {


    override fun getPokemons() = api.getPokemons().subscribeOn(Schedulers.io())

    override fun getPokemon(url: String) = api.getPokemon(url).subscribeOn(Schedulers.io())


}




