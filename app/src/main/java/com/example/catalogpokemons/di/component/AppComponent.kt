package com.example.catalogpokemons.di.component

import com.example.catalogpokemons.di.module.ApiModule
import com.example.catalogpokemons.di.module.AppModule
import com.example.catalogpokemons.di.module.CiceroneModule
import com.example.catalogpokemons.di.module.RepoModule
import com.example.catalogpokemons.presenter.MainActivityPresenter
import com.example.catalogpokemons.presenter.PokemonPresenter
import com.example.catalogpokemons.presenter.PokemonsPresenter
import com.example.catalogpokemons.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(pokemonPresenter: PokemonPresenter)
    fun inject(pokemonsPresenter: PokemonsPresenter)
}