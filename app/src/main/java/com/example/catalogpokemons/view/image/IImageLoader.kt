package com.example.catalogpokemons.view.image

interface IImageLoader<T> {
    fun imageLoad(url:String,container:T)
}