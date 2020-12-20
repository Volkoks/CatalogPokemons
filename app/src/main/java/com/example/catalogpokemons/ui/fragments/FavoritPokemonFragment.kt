package com.example.catalogpokemons.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.di.favorites.FavoritesPokemonsSubcomponent
import com.example.catalogpokemons.mvp.model.POKEMON
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.presenter.FavoritPokemonPresenter
import com.example.catalogpokemons.mvp.view.PokemonView
import com.example.catalogpokemons.mvp.view.image.GlideImgLoader
import com.example.catalogpokemons.mvp.view.image.IImageLoader
import com.example.catalogpokemons.ui.BackButtonListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_pokemon.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

/**
 * Фрагмент экрана Избранного Покемона
 */
class FavoritPokemonFragment(val imageLoader: IImageLoader<ImageView>) : MvpAppCompatFragment(),
    PokemonView, BackButtonListener {
    companion object {
        fun newInstance(pokemon: Pokemon) = FavoritPokemonFragment(GlideImgLoader()).apply {
            arguments = Bundle().apply {
                putParcelable(POKEMON, pokemon)
            }
        }
    }

    var favoritesSubcomponent: FavoritesPokemonsSubcomponent? = null

    private val presenter: FavoritPokemonPresenter by moxyPresenter {
        favoritesSubcomponent = PokemonApp.instance.initFavoritesSubcomponent()
        FavoritPokemonPresenter().apply {
            favoritesSubcomponent?.inject(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        presenter.pokemon = arguments?.getParcelable(POKEMON)
        return View.inflate(context, R.layout.fragment_favorit_pokemon, null)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_favorit_pokemon, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_from_favorites -> {
                presenter.deletePokemonFromFavorites()
                backPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    override fun init(pokemon: Pokemon) {
        activity?.title = pokemon.name
        base_experience_favorit_pokemon_tv.text =
            "Базовый опыт: ${pokemon.baseExperience.toString()}"
        height_favorit_pokemon_tv.text = "Рост: ${pokemon.height.toString()}"
        weight_favorit_pokemon_tv.text = "Вес: ${pokemon.weight}"
    }

    override fun loadImage(url: String) {
        imageLoader.imageLoad(url, image_favorit_pokemon_iv)
    }

    override fun showError(e: Throwable) {
        view?.let { e.message?.let { it1 -> Snackbar.make(it, it1, Snackbar.LENGTH_SHORT).show() } }
    }

    override fun finish() {
        favoritesSubcomponent = null
        PokemonApp.instance.finishFavoritesSubcomponent()
    }

    override fun backPressed() = presenter.backPressed()

}