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
import com.example.catalogpokemons.di.favorites.FavoritesPokemonsSubcomponent
import com.example.catalogpokemons.mvp.model.APP_NAME
import com.example.catalogpokemons.mvp.presenter.FavoritesPokemonsPresenter
import com.example.catalogpokemons.mvp.view.FavoritesPokemonsView
import com.example.catalogpokemons.mvp.view.image.GlideImgLoader
import com.example.catalogpokemons.ui.BackButtonListener
import com.example.catalogpokemons.ui.adapter.PokemonListAdapter
import kotlinx.android.synthetic.main.fragment_favorites_pokemons.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

/**
 * Фрагмент экрана Избранных покемонов(на данном фрагменте выводится список покемонов добавленных в
 * избранное
 */
class FavoritesPokemonsFragment : MvpAppCompatFragment(), FavoritesPokemonsView,
    BackButtonListener {


    companion object {
        fun newInstance() = FavoritesPokemonsFragment()
    }

    var favoritesSubcomponent: FavoritesPokemonsSubcomponent? = null

    val presenter: FavoritesPokemonsPresenter by moxyPresenter {
        favoritesSubcomponent = PokemonApp.instance.initFavoritesSubcomponent()
        FavoritesPokemonsPresenter().apply {
            favoritesSubcomponent?.inject(this)
        }
    }
    private var adapter: PokemonListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, R.layout.fragment_favorites_pokemons, null)
    }

    override fun init() {
        favorites_pokemon_rv.layoutManager = GridLayoutManager(context, 2)
        adapter = PokemonListAdapter(presenter.listFPListPresenter, GlideImgLoader())
        favorites_pokemon_rv.adapter = adapter
    }

    override fun update() {
        adapter?.notifyDataSetChanged()
    }

    override fun error(e: String?) {
        Toast.makeText(context, "Ошибка: ${e}", Toast.LENGTH_SHORT).show()
        e?.let { Log.d("ОШИБКА ROOM", it) }
    }

    override fun finish() {
        favoritesSubcomponent = null
        PokemonApp.instance.finishFavoritesSubcomponent()
    }

    override fun backPressed() = presenter.backPressed()

    override fun onResume() {
        activity?.title = APP_NAME
        presenter.loadFavoritesPokemon()
        super.onResume()
    }
}
