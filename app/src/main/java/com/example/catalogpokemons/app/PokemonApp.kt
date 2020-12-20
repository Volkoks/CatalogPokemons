package com.example.catalogpokemons.app

import android.app.Application
import com.example.catalogpokemons.di.component.AppComponent
import com.example.catalogpokemons.di.component.DaggerAppComponent
import com.example.catalogpokemons.di.favorites.FavoritesPokemonsSubcomponent
import com.example.catalogpokemons.di.module.AppModule
import com.example.catalogpokemons.di.pokemons.PokemonsSubcomponent
import dagger.Component
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class PokemonApp : Application() {
    companion object {
        lateinit var instance: PokemonApp
    }

    lateinit var appComponent: AppComponent

    var favoritesPokemonsSubcomponent: FavoritesPokemonsSubcomponent? = null
    var pokemonsSubcomponent: PokemonsSubcomponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun initFavoritesSubcomponent() = appComponent.favoritesPokemonsSubcomponent().also {
        favoritesPokemonsSubcomponent = it
    }

    fun finishFavoritesSubcomponent() {
        favoritesPokemonsSubcomponent = null
    }

    fun initPokemonsSubcomponent() = appComponent.pokemonsSubcomponent().also {
        pokemonsSubcomponent = it
    }

    fun finishPokemonsSubcomponent() {
        pokemonsSubcomponent = null
    }

}