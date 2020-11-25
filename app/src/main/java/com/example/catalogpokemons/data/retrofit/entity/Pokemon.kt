package com.example.catalogpokemons.data.retrofit.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

/**
 * Класс сущности Покемона для Retrofit
 */
@Parcelize
data class Pokemon(
    @Expose
    val id: Int,
    @Expose
    val name: String,
    @Expose
    val baseExperience: Int,
    @Expose
    val height: Int,
    @Expose
    val isDefault: Boolean,
    @Expose
    val order: Int,
    @Expose
    val weight: Int,
    @Expose
    val sprites:Sprites
) : Parcelable {
}