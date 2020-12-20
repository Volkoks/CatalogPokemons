package com.example.catalogpokemons.di.favorites.module

import com.example.catalogpokemons.di.favorites.FavoritesPokemonsScope
import com.example.catalogpokemons.mvp.model.room.database.FavoritsPokemonsDatabase
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.RoomFavoritesPokemonsRepo
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @FavoritesPokemonsScope
    @Provides
    fun favoritesPokemonRepo(db: FavoritsPokemonsDatabase): IFavoritesPokemonsRepo =
        RoomFavoritesPokemonsRepo(db)

}