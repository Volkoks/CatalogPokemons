package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Sprites
import com.example.catalogpokemons.mvp.model.room.favoritesPokemonsRepo.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.mvp.view.FavoritesPokemonsView
import com.example.catalogpokemons.mvp.view.PokemonItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class FavoritesPokemonsPresenter : MvpPresenter<FavoritesPokemonsView>() {

    @Inject
    lateinit var favoritesPokemonRepo: IFavoritesPokemonsRepo

    @Inject
    lateinit var mainThread: Scheduler

    @Inject
    lateinit var router: Router

    val listFPListPresenter = FavoritesPokemonListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadFavoritesPokemon()
        listFPListPresenter.itemClickListener = {

        }
    }

    private fun loadFavoritesPokemon() {
        favoritesPokemonRepo.getAllPokemon().observeOn(mainThread).subscribe({
            listFPListPresenter.pokemons.clear()
            listFPListPresenter.pokemons.addAll(it)
            viewState.update()
        }, {
            viewState.error(it.message)
        })
        favoritesPokemonRepo.getAllSprites().observeOn(mainThread).subscribe({
            listFPListPresenter.sprites.clear()
            listFPListPresenter.sprites.addAll(it)
            viewState.update()
        }, {
            viewState.error(it.message)
        })
    }

    inner class FavoritesPokemonListPresenter : IPokemonListPresenter {

        val pokemons = mutableListOf<Pokemon>()
        val sprites = mutableListOf<Sprites>()

        override var itemClickListener: ((PokemonItemView) -> Unit)? = null

        override fun getCount() = pokemons.size

        override fun bind(view: PokemonItemView) {
            val pokemon = pokemons[view.pos]
            view.bind(pokemon)

            val sprites = sprites[view.pos]
            sprites.front_default?.let { view.loadImg(it) }
        }

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}