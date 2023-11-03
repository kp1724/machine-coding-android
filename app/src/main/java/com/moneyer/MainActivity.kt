package com.moneyer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.moneyer.customviews.FullScreenView
import com.moneyer.dependencies.MainActivityComponent
import com.moneyer.viewmodel.MainActivityViewModel
import com.moneyer.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var fullScreenView: FullScreenView
    private lateinit var viewModel:MainActivityViewModel
    private lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = (application as App).coreComponent.mainActivityComponent().create()
        mainActivityComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
        setContentView(R.layout.activity_main)
        fullScreenView = findViewById(R.id.fullScreenView)
        viewModel.responseLiveData().observe(this) {
            fullScreenView.show(it)
        }
        viewModel.getPeople()
    }
}
