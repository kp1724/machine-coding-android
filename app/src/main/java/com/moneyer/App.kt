package com.moneyer

import android.app.Application
import com.moneyer.dependencies.CoreComponent
import com.moneyer.dependencies.DaggerCoreComponent

open class App : Application() {

    val coreComponent: CoreComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): CoreComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerCoreComponent.factory().create(applicationContext)
    }
}