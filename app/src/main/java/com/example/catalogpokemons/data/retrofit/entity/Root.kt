package com.example.catalogpokemons.data.retrofit.entity

import com.google.gson.annotations.Expose

data class Root(
    @Expose
    val count:Int? = null,
    @Expose
    val results: List<Results>? = null
) {
}