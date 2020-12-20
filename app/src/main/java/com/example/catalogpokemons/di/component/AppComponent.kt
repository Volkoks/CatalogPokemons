package com.example.catalogpokemons.di.component

import com.example.catalogpokemons.di.favorites.FavoritesPokemonsSubcomponent
import com.example.catalogpokemons.di.module.ApiModule
import com.example.catalogpokemons.di.module.AppModule
import com.example.catalogpokemons.di.module.CiceroneModule
import com.example.catalogpokemons.di.module.DatabaseModule
import com.example.catalogpokemons.di.pokemons.PokemonsSubcomponent
import com.example.catalogpokemons.mvp.presenter.MainActivityPresenter
import com.example.catalogpokemons.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Компонент для внедрения зависимостей через DI(основной компонент для всего приложения)
 */
@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun favoritesPokemonsSubcomponent(): FavoritesPokemonsSubcomponent
    fun pokemonsSubcomponent(): PokemonsSubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainActivityPresenter: MainActivityPresenter)
}