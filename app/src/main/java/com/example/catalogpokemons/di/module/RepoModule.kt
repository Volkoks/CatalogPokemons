package com.example.catalogpokemons.di.module

import com.example.catalogpokemons.mvp.model.retrofit.api.IPokemonDataSource
import com.example.catalogpokemons.mvp.model.retrofit.repository.PokemonsRepo
import com.example.catalogpokemons.mvp.model.retrofit.repository.IPokemonsRepos
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun PokeRepo(api: IPokemonDataSource): IPokemonsRepos = PokemonsRepo(api)
}