package com.example.catalogpokemons.di.component

import com.example.catalogpokemons.di.favorites.FavoritesPokemonsSubcomponent
import com.example.catalogpokemons.di.module.*
import com.example.catalogpokemons.di.pokemons.PokemonsSubcomponent
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

    fun favoritesPokemonsSubcomponent(): FavoritesPokemonsSubcomponent
    fun pokemonsSubcomponent(): PokemonsSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainActivityPresenter: MainActivityPresenter)
}