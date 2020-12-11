package com.example.catalogpokemons.mvp.model.retrofit.entity.pokemon

import com.google.gson.annotations.Expose

data class Other(
    @Expose
    val dream_word: DreamWorld? = null,
    @Expose
    val officialArtwork: OfficialArtwork? = null
) {}