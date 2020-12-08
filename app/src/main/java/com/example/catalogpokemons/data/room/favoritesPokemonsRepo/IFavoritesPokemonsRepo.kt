package com.example.catalogpokemons.data.room.favoritesPokemonsRepo

import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.data.room.entity.RoomPokemon
import com.example.catalogpokemons.data.room.entity.RoomSprites
import io.reactivex.rxjava3.core.Single

interface IFavoritesPokemonsRepo {
    fun addPokemon(pokemon:Pokemon?):Single<Pokemon?>
    fun getAllPokemon():Single<List<RoomPokemon>>
    fun getAllSprites():Single<List<RoomSprites>>
}