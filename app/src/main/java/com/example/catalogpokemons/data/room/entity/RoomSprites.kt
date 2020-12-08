package com.example.catalogpokemons.data.room.entity

import androidx.room.ColumnInfo
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
    @ColumnInfo
    var back_default: String? =null,
    @ColumnInfo
    var back_female: String? =null,
    @ColumnInfo
    var back_shiny: String? =null,
    @ColumnInfo
    var back_shiny_female: String? =null,
    @ColumnInfo
    var front_default: String? =null,
    @ColumnInfo
    var front_female: String? =null,
    @ColumnInfo
    var front_shiny: String? =null,
    @ColumnInfo
    var front_shiny_female: String? =null,
    @ColumnInfo
    val pokemonId: Int? = null
)