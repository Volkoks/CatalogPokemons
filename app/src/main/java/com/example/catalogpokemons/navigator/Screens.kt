package com.example.catalogpokemons.navigator


import androidx.fragment.app.Fragment
import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.ui.fragments.FavoritesPokemonsFragment
import com.example.catalogpokemons.ui.fragments.PokemonFragment
import com.example.catalogpokemons.ui.fragments.PokemonsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class PokemonsScreen : SupportAppScreen() {
        override fun getFragment() = PokemonsFragment.newInstance()
    }

    class PokemonScreen(val pokemon: Pokemon) : SupportAppScreen() {
        override fun getFragment() = PokemonFragment.newInstance(pokemon)
    }

    class FavoritesPokemonsScreen() : SupportAppScreen() {
        override fun getFragment() = FavoritesPokemonsFragment.newInstance()
    }
}

