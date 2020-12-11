package com.example.catalogpokemons.di.component

import com.example.catalogpokemons.di.module.*
import com.example.catalogpokemons.mvp.presenter.FavoritesPokemonsPresenter
import com.example.catalogpokemons.mvp.presenter.MainActivityPresenter
import com.example.catalogpokemons.mvp.presenter.PokemonPresenter
import com.example.catalogpokemons.mvp.presenter.PokemonsPresenter
import com.example.catalogpokemons.ui.activity.MainActivity
import com.example.catalogpokemons.ui.fragments.FavoritesPokemonsFragment
import dagger.Component
import javax.inject.Singleton

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
}