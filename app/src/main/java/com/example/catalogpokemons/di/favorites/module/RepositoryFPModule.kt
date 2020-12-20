package com.example.catalogpokemons.di.favorites.module

import com.example.catalogpokemons.di.favorites.FavoritesPokemonsScope
import com.example.catalogpokemons.mvp.model.room.database.FavoritsPokemonsDatabase
import com.example.catalogpokemons.mvp.model.room.repositories.favorites.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.model.room.repositories.favorites.RoomFavoritesPokemonsRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryFPModule {

    @FavoritesPokemonsScope
    @Provides
    fun favoritesPokemonRepo(db: FavoritsPokemonsDatabase): IFavoritesPokemonsRepo =
        RoomFavoritesPokemonsRepo(db)

}