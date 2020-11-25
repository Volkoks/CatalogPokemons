package com.example.catalogpokemons.data.retrofit.loader

interface IImageLoader<T> {
    fun imageLoad(url:String,container:T)
}