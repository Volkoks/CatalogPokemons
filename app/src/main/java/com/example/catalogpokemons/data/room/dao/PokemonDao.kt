package com.example.catalogpokemons.data.room.dao

import androidx.room.*
import com.example.catalogpokemons.data.room.entity.RoomPokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(pokemon: RoomPokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(vararg pokemon: RoomPokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(listPokemon: List<RoomPokemon>)

    @Update
    fun updatePokemon(pokemon: RoomPokemon)

    @Update
    fun updatePokemon(vararg pokemon: RoomPokemon)

    @Update
    fun updatePokemon(listPokemon: List<RoomPokemon>)

    @Delete
    fun deletePokemon(pokemon: RoomPokemon)

    @Delete
    fun deletePokemon(vararg pokemon: RoomPokemon)

    @Delete
    fun deletePokemon(listPokemon: List<RoomPokemon>)

    @Query("SELECT * FROM RoomPokemon")
    fun getAllPokemon(): List<RoomPokemon>
}