package com.example.catalogpokemons.mvp.presenter.list

import com.example.catalogpokemons.mvp.view.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun getCount(): Int
    fun bind(view: V)
}