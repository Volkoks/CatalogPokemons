package com.example.catalogpokemons.data.repository

import com.example.catalogpokemons.data.entity.Pokemon
import io.reactivex.rxjava3.core.Observable

class PokemonRepo {

    private val localRepo = listOf(
        Pokemon("Пикачу"),
        Pokemon("Бульбазабр"),
        Pokemon("Сквидвард")
    )
//        Метод для получения листа через Rx
    fun getPokemon(): Observable<List<Pokemon>> {
        return Observable.fromIterable(listOf(localRepo))
    }
}