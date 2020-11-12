package com.example.catalogpokemons.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.presenter.MainActivityPresenter
import com.example.catalogpokemons.view.MainActivityView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    private val presenter: MainActivityPresenter by moxyPresenter {
        MainActivityPresenter(PokemonApp.instance.getRouter)
    }
    private val navigatorHolder = PokemonApp.instance.navigatorHolder
    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}