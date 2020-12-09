package com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon

import com.google.gson.annotations.Expose

data class DreamWorld(
    @Expose
    val front_default: String? = null,
    @Expose
    val front_female: Any? = null
)
