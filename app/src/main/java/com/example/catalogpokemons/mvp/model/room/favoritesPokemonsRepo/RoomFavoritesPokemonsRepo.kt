package com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Sprites
import com.example.catalogpokemons.mvp.model.room.database.PokemonDatabase
import com.example.catalogpokemons.mvp.model.room.entity.RoomPokemon
import com.example.catalogpokemons.mvp.model.room.entity.RoomSprites
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Репозиторий для Избранных покемонов(добавление в избранное/получение избранных покемонов)
 */
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
        pokemon?.let { pokemon ->
            val roomSprites = RoomSprites(
                back_default = pokemon.sprites?.back_default,
                back_female = pokemon.sprites?.back_female,
                back_shiny = pokemon.sprites?.back_shiny,
                back_shiny_female = pokemon.sprites?.back_shiny_female,
                front_default = pokemon.sprites?.front_default,
                front_female = pokemon.sprites?.front_female,
                front_shiny = pokemon.sprites?.front_shiny,
                front_shiny_female = pokemon.sprites?.front_shiny_female,
                pokemonId = pokemon.id
            )
            db.roomSpritesDao.insertSprites(roomSprites)
        }
        pokemon
    }.subscribeOn(Schedulers.io())

    override fun getAllPokemon() = Single.fromCallable {
        db.pokemonDao.getAllPokemon().map { pokemon ->
            Pokemon(
                pokemon.id,
                pokemon.name,
                pokemon.baseExperience,
                pokemon.height,
                pokemon.isDefault,
                pokemon.order,
                pokemon.weight,
                pokemon.id?.let { getSpritesForById(it).blockingGet() }
            )
        }
    }.subscribeOn(Schedulers.io())

    override fun getSpritesForById(pokemonId: Int): Single<Sprites> = Single.fromCallable {
        val roomSprites = db.roomSpritesDao.getById(pokemonId)
        Sprites(
            roomSprites.back_default,
            roomSprites.back_female,
            roomSprites.back_shiny,
            roomSprites.back_shiny_female,
            roomSprites.front_default,
            roomSprites.front_female,
            roomSprites.front_shiny,
            roomSprites.front_shiny_female
        )
    }

    override fun deletePOkemon(pokemon: Pokemon) = Single.fromCallable{
        val roomPokemon = pokemon.id?.let { db.pokemonDao.getRoomPokemonById(it) }
        roomPokemon?.let { db.pokemonDao.deletePokemon(it) }
        pokemon
    }.subscribeOn(Schedulers.io())


}