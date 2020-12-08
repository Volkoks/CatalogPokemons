package com.example.catalogpokemons.presenter

import com.example.catalogpokemons.data.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.data.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.view.PokemonView
import moxy.MvpPresenter
import javax.inject.Inject

/**
 * Презентер для фрагмента Покемона ( здесь происходит логика взаимодействия фрагмента и данных)
 */
class PokemonPresenter() : MvpPresenter<PokemonView>() {

    @Inject
    lateinit var db: IFavoritesPokemonsRepo

    var pokemon: Pokemon? = null


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        pokemon?.let {
            viewState.init(it)
            it.sprites?.front_default?.let { it1 -> viewState.loadImage(it1) }
        }
    }

    fun addPokemonInFavorites(){
        pokemon?.let {
            db.addPokemon(pokemon)
        }
    }


}