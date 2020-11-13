package com.example.catalogpokemons.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catalogpokemons.R
import com.example.catalogpokemons.data.POKEMON
import com.example.catalogpokemons.data.entity.Pokemon
import com.example.catalogpokemons.presenter.PokemonPresenter
import com.example.catalogpokemons.view.PokemonView
import kotlinx.android.synthetic.main.fragment_pokemon.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class PokemonFragment : MvpAppCompatFragment(), PokemonView {

    companion object {
        fun newInstance(pokemon: Pokemon): PokemonFragment {
            val fragment = PokemonFragment()
            var bundle = Bundle()
            bundle.putParcelable(POKEMON, pokemon)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val presenter: PokemonPresenter by moxyPresenter {
        PokemonPresenter()
    }
    private var pokemon: Pokemon? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_pokemon, null)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemon = arguments?.getParcelable(POKEMON)
    }

    override fun init() {
        pokemon_name_tv.text = pokemon?.name
        base_experience_tv.text = pokemon?.base_experience.toString()
        height_tv.text = pokemon?.height.toString()
    }
}