package com.example.catalogpokemons.data.room.dao

import androidx.room.*
import com.example.catalogpokemons.data.room.entity.RoomSprites

@Dao
interface RoomSpritesDao {
    @Insert
    fun insertSprites(roomSprites: RoomSprites)

    @Insert
    fun insertSprites(vararg roomSprites: RoomSprites)

    @Insert
    fun insertSprites(listSprites:List<RoomSprites>)

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
}