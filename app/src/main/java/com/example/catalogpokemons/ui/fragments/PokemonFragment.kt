package com.example.catalogpokemons.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.catalogpokemons.R
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
        fun newInstance(pokemon: Pokemon): PokemonFragment {
            val fragment = PokemonFragment(GlideImgLoader())
            val bundle = Bundle()
            bundle.putParcelable(POKEMON, pokemon)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val presenter: PokemonPresenter by moxyPresenter {
        PokemonPresenter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = View.inflate(context, R.layout.fragment_pokemon, null)
        presenter.pokemon = arguments?.getParcelable(POKEMON)
        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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