package com.example.catalogpokemons.data.retrofit.entity.pokemon

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize


data class Sprites(
    @Expose
    var back_default: String,
    @Expose
    var back_female: String,
    @Expose
    var back_shiny: String,
    @Expose
    var back_shiny_female: String,
    @Expose
    var front_default: String,
    @Expose
    var front_female: String,
    @Expose
    var front_shiny: String,
    @Expose
    var front_shiny_female: String,
    @Expose
    var other: Other? = null
)