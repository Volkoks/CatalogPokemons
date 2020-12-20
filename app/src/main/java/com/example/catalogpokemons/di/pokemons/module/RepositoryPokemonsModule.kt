package com.example.catalogpokemons.di.pokemons.module

import com.example.catalogpokemons.di.pokemons.PokemonsScope
import com.example.catalogpokemons.mvp.model.retrofit.api.IPokemonDataSource
import com.example.catalogpokemons.mvp.model.retrofit.repository.IPokemonsRepos
import com.example.catalogpokemons.mvp.model.retrofit.repository.PokemonsRepo
import dagger.Module
import dagger.Provides

@Module
class RepositoryPokemonsModule {

    @PokemonsScope
    @Provides
    fun PokeRepo(api: IPokemonDataSource): IPokemonsRepos = PokemonsRepo(api)

}