package com.example.catalogpokemons.di.pokemons

import com.example.catalogpokemons.di.pokemons.module.FavoritesDBModule
import com.example.catalogpokemons.di.pokemons.module.RepositoryPokemonsModule
import com.example.catalogpokemons.mvp.presenter.PokemonPresenter
import com.example.catalogpokemons.mvp.presenter.PokemonsPresenter
import dagger.Subcomponent

@PokemonsScope
@Subcomponent(
    modules = [
        FavoritesDBModule::class,
        RepositoryPokemonsModule::class
    ]
)
interface PokemonsSubcomponent {
    fun inject(pokemonPresenter: PokemonPresenter)
    fun inject(pokemonsPresenter: PokemonsPresenter)
}