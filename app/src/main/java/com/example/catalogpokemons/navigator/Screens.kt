package com.example.catalogpokemons.navigator


import com.example.catalogpokemons.ui.fragments.PokemonsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class PokemonsScreen : SupportAppScreen() {
        override fun getFragment() = PokemonsFragment.newInstance()
    }
}
