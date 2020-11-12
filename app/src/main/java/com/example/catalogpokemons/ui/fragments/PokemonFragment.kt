package com.example.catalogpokemons.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catalogpokemons.R
import com.example.catalogpokemons.data.POKEMON
import com.example.catalogpokemons.data.entity.Pokemon
import com.example.catalogpokemons.view.PokemonView
import moxy.MvpAppCompatFragment


class PokemonFragment : MvpAppCompatFragment(), PokemonView {

    companion object {
        fun newInstance(pokemon: Pokemon): PokemonFragment {
            val fragment = PokemonFragment()
            var bundle = Bundle()
            bundle.putParcelable(POKEMON, pokemon)
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_pokemon, null)

    override fun init() {

    }
}