package com.example.dependencynow.modul.home

import android.app.Application
import com.example.dependencynow.screens.home.HomeActivity
import com.example.dependencynow.screens.home.HomeViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Named
import javax.inject.Singleton

@SingleScope
@Component(modules = [HomeModule::class])
interface HomeComponent {

    @Singleton
    fun getViewModel(): HomeViewModel

    fun inject(homeActivity: HomeActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun seedData(@Named("your_name") txt: String): Builder
        fun build(): HomeComponent
    }
}


