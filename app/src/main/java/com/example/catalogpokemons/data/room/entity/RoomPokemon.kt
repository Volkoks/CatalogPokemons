package com.example.catalogpokemons.data.room.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class RoomPokemon(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val baseExperience: Int?,
    val height: Int?,
    val isDefault: Boolean?,
    val order: Int? ,
    val weight: Int?,
)
