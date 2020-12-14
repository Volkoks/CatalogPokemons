package com.example.catalogpokemons.mvp.model.retrofit.repository

import com.example.catalogpokemons.mvp.model.retrofit.api.IPokemonDataSource
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Репозиторий покемонов из сети
 */
class PokemonsRepo(val api: IPokemonDataSource) : IPokemonsRepos {
    override fun getRoot() = api.getPokemons().subscribeOn(Schedulers.io())
    override fun getPokemon(url: String) = api.getPokemon(url).subscribeOn(Schedulers.io())

}




