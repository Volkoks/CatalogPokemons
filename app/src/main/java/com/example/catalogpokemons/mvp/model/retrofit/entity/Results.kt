package com.example.catalogpokemons.mvp.model.retrofit.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    @Expose
    val name:String? = null,
    @Expose
    val url:String? = null
):Parcelable {
}