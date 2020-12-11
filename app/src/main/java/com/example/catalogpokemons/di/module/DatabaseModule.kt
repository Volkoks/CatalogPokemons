package com.example.catalogpokemons.di.module

import androidx.room.Room
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.mvp.model.room.database.PokemonDatabase
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.RoomFavoritesPokemonsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun db(app: PokemonApp): PokemonDatabase = Room.databaseBuilder(
        app, PokemonDatabase::class.java, PokemonDatabase.DB_NAME
    ).build()

    @Singleton
    @Provides
    fun favoritesPokemonRepo(db: PokemonDatabase):IFavoritesPokemonsRepo = RoomFavoritesPokemonsRepo(db)

}