package com.example.catalogpokemons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catalogpokemons.R
import com.example.catalogpokemons.view.FavoritesPokemonsView
import moxy.MvpAppCompatFragment

class FavoritesPokemonsFragment : MvpAppCompatFragment(), FavoritesPokemonsView {


    companion object {
        fun newInstance() = FavoritesPokemonsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, R.layout.fragment_favorites_pokemons, null)
    }
}
