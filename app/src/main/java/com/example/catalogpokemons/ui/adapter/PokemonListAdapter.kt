package com.example.catalogpokemons.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogpokemons.R
import com.example.catalogpokemons.mvp.model.retrofit.entity.Results
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.view.image.IImageLoader
import com.example.catalogpokemons.mvp.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.mvp.view.PokemonItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pokemon_card.view.*

class PokemonListAdapter(
    val presenter: IPokemonListPresenter,
    val imageLoader: IImageLoader<ImageView>
) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.pokemon_card, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener {
            presenter.itemClickListener?.invoke(holder)
        }
        presenter.bind(holder)
    }

    override fun getItemCount() = presenter.getCount()


    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer, PokemonItemView {

        override fun initName(result: Results) = with(containerView) {
            pokemon_name_tv_card.text = result.name
        }

        override fun bind(pokemon: Pokemon) = with(containerView) {
            pokemon_name_tv_card.text = pokemon.name
            pokemon_id_tv_card.text = pokemon.id.toString()
            base_experience_tv_card.text = pokemon.baseExperience.toString()
        }

        override fun loadImg(url: String) = with(containerView) {
            imageLoader.imageLoad(url, pokemon_iv)
        }

        override var pos = -1

    }
}