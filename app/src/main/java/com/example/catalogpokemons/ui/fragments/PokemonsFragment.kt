package com.example.catalogpokemons.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.di.pokemons.PokemonsSubcomponent
import com.example.catalogpokemons.mvp.model.APP_NAME
import com.example.catalogpokemons.mvp.view.image.GlideImgLoader
import com.example.catalogpokemons.mvp.presenter.PokemonsPresenter
import com.example.catalogpokemons.ui.adapter.PokemonListAdapter
import com.example.catalogpokemons.mvp.view.PokemonsView
import com.example.catalogpokemons.ui.BackButtonListener
import kotlinx.android.synthetic.main.fragment_pokemons.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

/**
 * Фрагмент эрана с листом Покемонов(здесь отображается список покемонов полученных из сети)
 */
class PokemonsFragment : MvpAppCompatFragment(), PokemonsView, BackButtonListener {
    companion object {
        fun newInstance() = PokemonsFragment()
    }

    var pokemonsSubcomponent: PokemonsSubcomponent? = null

    val presenter: PokemonsPresenter by moxyPresenter {
        pokemonsSubcomponent = PokemonApp.instance.initPokemonsSubcomponent()
        PokemonsPresenter().apply {
            pokemonsSubcomponent?.inject(this)
        }

    }
    var adapter: PokemonListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val v = View.inflate(context, R.layout.fragment_pokemons, null)
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pokemons_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favotites_item_menu -> {
                presenter.replaceToFavoritesPokemonsFragment()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun init() {
        pokemons_rv.layoutManager = GridLayoutManager(context, 2)
        adapter = PokemonListAdapter(presenter.listPresenter, GlideImgLoader())
        pokemons_rv.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun snowError(error: Throwable) {
        Toast.makeText(context, "Ошибка: ${error}", Toast.LENGTH_SHORT).show()
        Log.d("ОШИБКА RETROFIT", error.message.toString())
    }

    override fun onResume() {
        super.onResume()
        activity?.title = APP_NAME
    }

    override fun backPressed() = presenter.backPressed()
}