package com.example.catalogpokemons.di.favorites

import com.example.catalogpokemons.di.favorites.module.RepositoryFPModule
import com.example.catalogpokemons.mvp.presenter.FavoritPokemonPresenter
import com.example.catalogpokemons.mvp.presenter.FavoritesPokemonsPresenter
import com.example.catalogpokemons.mvp.presenter.PokemonPresenter
import dagger.Subcomponent

@FavoritesPokemonsScope
@Subcomponent(
    modules = [
        RepositoryFPModule::class
    ]
)
interface FavoritesPokemonsSubcomponent {
    fun inject(favoritesPokemonsPresenter: FavoritesPokemonsPresenter)
    fun inject(favoritePokemonPresenter: FavoritPokemonPresenter)
}