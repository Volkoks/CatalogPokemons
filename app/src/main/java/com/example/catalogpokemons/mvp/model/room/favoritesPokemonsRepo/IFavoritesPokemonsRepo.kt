package com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Sprites
import io.reactivex.rxjava3.core.Single

interface IFavoritesPokemonsRepo {
    fun addPokemon(pokemon:Pokemon?):Single<Pokemon?>
    fun getAllPokemon():Single<List<Pokemon>>
    fun getAllSprites():Single<List<Sprites>>
}