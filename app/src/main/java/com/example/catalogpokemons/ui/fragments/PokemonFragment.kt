package com.example.catalogpokemons.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.data.POKEMON
import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.view.image.GlideImgLoader
import com.example.catalogpokemons.view.image.IImageLoader
import com.example.catalogpokemons.presenter.PokemonPresenter
import com.example.catalogpokemons.view.PokemonView
import kotlinx.android.synthetic.main.fragment_pokemon.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

/**
 * Фрагмент экрана Покемона(Здесь осуществляется отображение всех данных для одного покемона)
 */
class PokemonFragment(val imageLoader: IImageLoader<ImageView>) : MvpAppCompatFragment(),
    PokemonView {

    companion object {
        fun newInstance(pokemon: Pokemon) = PokemonFragment(GlideImgLoader()).apply {
            arguments = Bundle().apply {
                putParcelable(POKEMON, pokemon)
            }
        }
    }


    private val presenter: PokemonPresenter by moxyPresenter {
        PokemonPresenter().apply {
            PokemonApp.instance.appComponent.inject(this)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val v = View.inflate(context, R.layout.fragment_pokemon, null)
        presenter.pokemon = arguments?.getParcelable(POKEMON)
        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pokemon_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_to_favorites -> presenter.addPokemonInFavorites()
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetTextI18n")
    override fun init(pokemon: Pokemon) {
        activity?.title = pokemon.name
        base_experience_tv.text = "Базовый опыт: ${pokemon.baseExperience.toString()}"
        height_tv.text = "Рост: ${pokemon.height.toString()}"
        weight_tv.text = "Вес: ${pokemon.weight}"

    }

    override fun loadImage(url: String) {
        imageLoader.imageLoad(url, image_pokemon_iv)
    }
}