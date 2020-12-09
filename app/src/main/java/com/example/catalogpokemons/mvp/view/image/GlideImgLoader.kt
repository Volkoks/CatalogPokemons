package com.example.catalogpokemons.mvp.view.image

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImgLoader : IImageLoader<ImageView> {
    override fun imageLoad(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}