package com.example.catalogpokemons.navigator


import com.example.catalogpokemons.mvp.model.MENU_POKEMON
import com.example.catalogpokemons.mvp.model.retrofit.entity.Results
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.ui.fragments.FavoritPokemonFragment
import com.example.catalogpokemons.ui.fragments.FavoritesPokemonsFragment
import com.example.catalogpokemons.ui.fragments.PokemonFragment
import com.example.catalogpokemons.ui.fragments.PokemonsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

/**
 * Класс экранов для Cicerone
 */
class Screens {
    class PokemonsScreen : SupportAppScreen() {
        override fun getFragment() = PokemonsFragment.newInstance()
    }

    class PokemonScreen(val result: Results) : SupportAppScreen() {
        override fun getFragment() = PokemonFragment.newInstance(result, MENU_POKEMON)
    }

    class FavoritePokemon(val pokemon: Pokemon) : SupportAppScreen() {
        override fun getFragment() = FavoritPokemonFragment.newInstance(pokemon)
    }

    class FavoritesPokemonsScreen() : SupportAppScreen() {
        override fun getFragment() = FavoritesPokemonsFragment.newInstance()
    }
}

