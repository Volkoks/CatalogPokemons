package com.example.catalogpokemons.mvp.presenter

import com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon.Pokemon
import com.example.catalogpokemons.mvp.model.room.repositories.favorites.IFavoritesPokemonsRepo
import com.example.catalogpokemons.mvp.presenter.list.IPokemonListPresenter
import com.example.catalogpokemons.mvp.view.FavoritesPokemonsView
import com.example.catalogpokemons.mvp.view.PokemonItemView
import com.example.catalogpokemons.navigator.Screens
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * Презентер для фрагмента Избранных покемонов( FavoritesPokemonsFragment)
 */
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
            router.navigateTo(Screens.FavoritePokemon(listFPListPresenter.pokemons[it.pos]))
        }
    }

    fun loadFavoritesPokemon() {
        favoritesPokemonRepo.getAllPokemon().observeOn(mainThread).subscribe({
            listFPListPresenter.pokemons.clear()
            listFPListPresenter.pokemons.addAll(it)
            viewState.update()
        }, {
            viewState.error(it.message)
        })
    }

    /**
     * Презентер для каждой карточки покемона в RV.
     */
    inner class FavoritesPokemonListPresenter : IPokemonListPresenter {

        val pokemons = mutableListOf<Pokemon>()

        override var itemClickListener: ((PokemonItemView) -> Unit)? = null

        override fun getCount() = pokemons.size

        override fun bind(view: PokemonItemView) {
            val pokemon = pokemons[view.pos]
            view.bind(pokemon)
            pokemon.sprites?.front_default?.let { view.loadImg(it) }
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.finish()
    }

}