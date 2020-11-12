package com.example.catalogpokemons.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.data.repository.PokemonRepo
import com.example.catalogpokemons.presenter.PokemonsPresenter
import com.example.catalogpokemons.ui.adapter.PokemonListAdapter
import com.example.catalogpokemons.view.PokemonsView
import kotlinx.android.synthetic.main.fragment_pokemons.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class PokemonsFragment : MvpAppCompatFragment(), PokemonsView {
    companion object {
        fun newInstance() = PokemonsFragment()
    }

    val presenter: PokemonsPresenter by moxyPresenter {
        PokemonsPresenter(PokemonRepo(), PokemonApp.instance.getRouter)
    }
    var adapter: PokemonListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_pokemons, null)

    override fun init() {
        pokemons_rv.layoutManager = GridLayoutManager(context, 2)
        adapter = PokemonListAdapter(presenter.listPresenter)
        pokemons_rv.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}