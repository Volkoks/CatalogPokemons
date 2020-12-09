package com.example.catalogpokemons.mvp.view.image

interface IImageLoader<T> {
    fun imageLoad(url:String,container:T)
}