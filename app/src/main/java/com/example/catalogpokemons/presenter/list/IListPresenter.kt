package com.example.catalogpokemons.presenter.list

import com.example.catalogpokemons.view.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun getCount(): Int
    fun bind(view: V)
}