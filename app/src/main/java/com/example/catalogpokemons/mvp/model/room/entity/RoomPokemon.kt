package com.example.catalogpokemons.mvp.model.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomPokemon(
    @PrimaryKey
    @ColumnInfo
    val id: Int?,
    @ColumnInfo
    val name: String?,
    @ColumnInfo
    val baseExperience: Int?,
    @ColumnInfo
    val height: Int?,
    @ColumnInfo
    val isDefault: Boolean?,
    @ColumnInfo
    val order: Int? ,
    @ColumnInfo
    val weight: Int?
)
