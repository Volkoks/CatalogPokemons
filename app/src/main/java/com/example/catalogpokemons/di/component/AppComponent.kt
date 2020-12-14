package com.example.catalogpokemons.di.component

import com.example.catalogpokemons.di.module.*
import com.example.catalogpokemons.mvp.presenter.*
import com.example.catalogpokemons.ui.activity.MainActivity
import com.example.catalogpokemons.ui.fragments.FavoritesPokemonsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Компонент для внедрения зависимостей через DI
 */
@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        RepoModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(pokemonPresenter: PokemonPresenter)
    fun inject(pokemonsPresenter: PokemonsPresenter)
    fun inject(favoritesPokemonsPresenter: FavoritesPokemonsPresenter)
    fun inject(favoritPokemonPresenter: FavoritPokemonPresenter)
}