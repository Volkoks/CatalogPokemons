package com.example.catalogpokemons.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.catalogpokemons.data.room.dao.PokemonDao
import com.example.catalogpokemons.data.room.dao.RoomSpritesDao
import com.example.catalogpokemons.data.room.entity.RoomPokemon
import com.example.catalogpokemons.data.room.entity.RoomSprites

@Database(entities = [RoomPokemon::class,RoomSprites::class],exportSchema = false, version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "pokemon_db"
    }
    abstract val pokemonDao: PokemonDao
    abstract val roomSpritesDao: RoomSpritesDao
}