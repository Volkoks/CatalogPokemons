package com.example.catalogpokemons.di.module

import com.example.catalogpokemons.app.PokemonApp
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

@Module
class AppModule(val app:PokemonApp) {

    @Provides
    fun app():PokemonApp{
        return app
    }

    @Provides
    fun mainThread():Scheduler{
        return AndroidSchedulers.mainThread()
    }
}