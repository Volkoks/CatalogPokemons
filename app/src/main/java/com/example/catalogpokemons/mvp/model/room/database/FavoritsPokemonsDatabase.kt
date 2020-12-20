package com.example.catalogpokemons.mvp.model.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.catalogpokemons.mvp.model.room.dao.favorites.RoomPokemonDao
import com.example.catalogpokemons.mvp.model.room.dao.favorites.RoomSpritesDao
import com.example.catalogpokemons.mvp.model.room.entity.favorites.RoomPokemon
import com.example.catalogpokemons.mvp.model.room.entity.favorites.RoomSprites

@Database(entities = [RoomPokemon::class, RoomSprites::class],version = 1)
abstract class FavoritsPokemonsDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "pokemon_db"
    }
    abstract val roomPokemonDao: RoomPokemonDao
    abstract val roomSpritesDao: RoomSpritesDao
}