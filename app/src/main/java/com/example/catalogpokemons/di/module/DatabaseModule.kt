package com.example.catalogpokemons.di.module

import androidx.room.Room
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.mvp.model.room.database.FavoritsPokemonsDatabase
import com.example.catalogpokemons.mvp.model.room.repositories.favorites.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.model.room.repositories.favorites.RoomFavoritesPokemonsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun favoritsPokemonsDatabase(app: PokemonApp): FavoritsPokemonsDatabase = Room.databaseBuilder(
        app, FavoritsPokemonsDatabase::class.java, FavoritsPokemonsDatabase.DB_NAME
    ).build()
}