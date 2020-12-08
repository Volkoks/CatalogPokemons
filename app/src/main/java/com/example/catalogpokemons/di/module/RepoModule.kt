package com.example.catalogpokemons.di.module

import com.example.catalogpokemons.data.retrofit.api.IPokemonDataSource
import com.example.catalogpokemons.data.retrofit.repository.PokemonsRepo
import com.example.catalogpokemons.data.retrofit.repository.IPokemonsRepos
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun PokeRepo(api: IPokemonDataSource): IPokemonsRepos = PokemonsRepo(api)
}