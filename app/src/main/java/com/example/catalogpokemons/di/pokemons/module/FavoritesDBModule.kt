package com.example.catalogpokemons.di.pokemons.module


import com.example.catalogpokemons.di.pokemons.PokemonsScope
import com.example.catalogpokemons.mvp.model.room.database.FavoritsPokemonsDatabase
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.RoomFavoritesPokemonsRepo
import dagger.Module
import dagger.Provides

@Module
class FavoritesDBModule {
    @PokemonsScope
    @Provides
    fun favoritesPokemonRepo(db: FavoritsPokemonsDatabase): IFavoritesPokemonsRepo =
        RoomFavoritesPokemonsRepo(db)
}