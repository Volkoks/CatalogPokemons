package com.example.catalogpokemons.app

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class PokemonApp : Application() {
    companion object {
        lateinit var instance: PokemonApp
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val getRouter
        get() = cicerone.router
    val navigatorHolder
        get() = cicerone.navigatorHolder
}