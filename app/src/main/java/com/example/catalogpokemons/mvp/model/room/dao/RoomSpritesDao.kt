package com.example.catalogpokemons.mvp.model.room.dao

import androidx.room.*
import com.example.catalogpokemons.mvp.model.room.entity.RoomSprites
import io.reactivex.rxjava3.core.Single

@Dao
interface RoomSpritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSprites(roomSprites: RoomSprites)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSprites(vararg roomSprites: RoomSprites)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSprites(listSprites: List<RoomSprites>)

    @Update
    fun updateSprites(roomSprites: RoomSprites)

    @Update
    fun updateSprites(vararg roomSprites: RoomSprites)

    @Update
    fun updateSprites(listSprites: List<RoomSprites>)

    @Delete
    fun deleteSprites(roomSprites: RoomSprites)

    @Delete
    fun deleteSprites(vararg roomSprites: RoomSprites)

    @Delete
    fun deleteSprites(listSprites: List<RoomSprites>)

    @Query("SELECT * FROM RoomSprites")
    fun getAllSprites(): List<RoomSprites>

    @Query("SELECT * FROM RoomSprites WHERE pokemonId = :pokemonId LIMIT 1")
    fun getById(pokemonId: Int): RoomSprites
}