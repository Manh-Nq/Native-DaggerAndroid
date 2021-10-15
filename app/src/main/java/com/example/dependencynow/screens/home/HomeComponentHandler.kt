package com.example.dependencynow.screens.home

import com.example.dependencynow.modul.home.customscope.HomeComponent
import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Singleton


class HomeComponentHandler @Inject constructor(private val userComponentFactory: HomeComponent.Builder)
    : GeneratedComponentManager<HomeComponent> {

    var userComponent: HomeComponent? = null
        private set

    fun create() {
        if (userComponent == null) {
            userComponent = userComponentFactory.create()
        }
    }

    fun destroy() {
        userComponent = null
    }

    override fun generatedComponent(): HomeComponent {
        return userComponent!!
    }
}