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
    val id: Int? = null,
    @Expose
    val name: String? = null,
    @Expose
    val baseExperience: Int? = null,
    @Expose
    val height: Int? = null,
    @Expose
    val isDefault: Boolean? = null,
    @Expose
    val order: Int? = null,
    @Expose
    val weight: Int? = null,
    @Expose
    val sprites:Sprites? = null
) : Parcelable {
}