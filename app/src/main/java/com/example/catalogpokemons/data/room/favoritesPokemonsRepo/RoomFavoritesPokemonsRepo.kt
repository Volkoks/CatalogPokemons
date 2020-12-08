package com.example.catalogpokemons.data.room.favoritesPokemonsRepo

import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.data.room.database.PokemonDatabase
import com.example.catalogpokemons.data.room.entity.RoomPokemon
import com.example.catalogpokemons.data.room.entity.RoomSprites
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomFavoritesPokemonsRepo(val db: PokemonDatabase) : IFavoritesPokemonsRepo {


    override fun addPokemon(pokemon: Pokemon?) = Single.fromCallable {
        pokemon?.let {
            val roomPokemon = RoomPokemon(
                pokemon.id ?: 0,
                pokemon.name ?: "",
                pokemon.baseExperience ?: 0,
                pokemon.height ?: 0,
                pokemon.isDefault ?: false,
                pokemon.order ?: 0,
                pokemon.weight ?: 0
            )
            db.pokemonDao.insertPokemon(roomPokemon)
        }
        pokemon?.sprites?.let { pokemon ->
            val roomSprites = RoomSprites(
                back_default = pokemon.back_default,
                back_female = pokemon.back_female,
                back_shiny = pokemon.back_shiny,
                back_shiny_female = pokemon.back_shiny_female,
                front_default = pokemon.front_default,
                front_female = pokemon.front_female,
                front_shiny = pokemon.front_shiny,
                front_shiny_female = pokemon.front_shiny_female
            )
            db.roomSpritesDao.insertSprites(roomSprites)
        }
        pokemon
    }.subscribeOn(Schedulers.io())

    override fun getAllPokemon() = Single.fromCallable {
        db.pokemonDao.getAllPokemon()
    }.subscribeOn(Schedulers.io())

    override fun getAllSprites() = Single.fromCallable {
        db.roomSpritesDao.getAllSprites()
    }.subscribeOn(Schedulers.io())


}