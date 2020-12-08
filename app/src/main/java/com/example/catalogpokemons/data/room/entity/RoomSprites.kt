package com.example.catalogpokemons.data.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomPokemon::class,
        parentColumns = ["id"],
        childColumns = ["pokemonId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomSprites(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var back_default: String,
    var back_female: String,
    var back_shiny: String,
    var back_shiny_female: String,
    var front_default: String,
    var front_female: String,
    var front_shiny: String,
    var front_shiny_female: String,
    val pokemonId: Int? = null
)