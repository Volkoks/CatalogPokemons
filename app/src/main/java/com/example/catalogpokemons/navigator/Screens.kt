package com.example.catalogpokemons.navigator


import com.example.catalogpokemons.ui.PokemonsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class PokemonScreen : SupportAppScreen() {
        override fun getFragment() = PokemonsFragment.newInstance()
    }
}
