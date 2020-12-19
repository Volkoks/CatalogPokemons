package com.example.catalogpokemons.di.favorites

import com.example.catalogpokemons.di.favorites.module.RepositoryModule
import com.example.catalogpokemons.mvp.presenter.FavoritPokemonPresenter
import com.example.catalogpokemons.mvp.presenter.FavoritesPokemonsPresenter
import com.example.catalogpokemons.mvp.presenter.PokemonPresenter
import dagger.Subcomponent

@FavoritesPokemonsScope
@Subcomponent(
    modules = [
        RepositoryModule::class
    ]
)
interface FavoritesPokemonsSubcomponent {

    fun inject(favoritesPokemonsPresenter: FavoritesPokemonsPresenter)
    fun inject(favoritePokemonPresenter: FavoritPokemonPresenter)
    fun inject(pokemonPresenter: PokemonPresenter)
}