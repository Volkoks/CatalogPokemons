package com.example.catalogpokemons.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    var name: String,
    var base_experience: Int,
    var height: Int,
    var id: Int = -1,
//    var order: Float,
//    val sprites: Sprites
) : Parcelable {
}