package com.example.catalogpokemons.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.data.APP_NAME
import com.example.catalogpokemons.data.retrofit.api.ApiHolder
import com.example.catalogpokemons.view.image.GlideImgLoader
import com.example.catalogpokemons.data.retrofit.loader.LoaderPokemons
import com.example.catalogpokemons.presenter.PokemonsPresenter
import com.example.catalogpokemons.ui.adapter.PokemonListAdapter
import com.example.catalogpokemons.view.PokemonsView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_pokemons.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

/**
 * Фрагмент эрана с листом Покемонов
 */
class PokemonsFragment : MvpAppCompatFragment(), PokemonsView {
    companion object {
        fun newInstance() = PokemonsFragment()
    }

    val presenter: PokemonsPresenter by moxyPresenter {
        PokemonsPresenter(
            AndroidSchedulers.mainThread(),
            LoaderPokemons(ApiHolder.api),
            PokemonApp.instance.getRouter)
    }
    var adapter: PokemonListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_pokemons, null)

    override fun init() {
        pokemons_rv.layoutManager = GridLayoutManager(context, 2)
        adapter = PokemonListAdapter(presenter.listPresenter, GlideImgLoader())
        pokemons_rv.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun snowError(error: Throwable) {
        Toast.makeText(context,"Ошибка: ${error}",Toast.LENGTH_SHORT).show()
        Log.d("ОШИБКА RETROFIT",error.message.toString())
    }

    override fun onResume() {
        super.onResume()
        activity?.title = APP_NAME
    }
}