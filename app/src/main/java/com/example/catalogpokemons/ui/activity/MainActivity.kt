package com.example.catalogpokemons.ui.activity

import android.os.Bundle
import com.example.catalogpokemons.R
import com.example.catalogpokemons.app.PokemonApp
import com.example.catalogpokemons.mvp.presenter.MainActivityPresenter
import com.example.catalogpokemons.mvp.view.MainActivityView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    private val presenter: MainActivityPresenter by moxyPresenter {
        MainActivityPresenter().apply {
            PokemonApp.instance.appComponent.inject(this)
        }
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PokemonApp.instance.appComponent.inject(this)
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