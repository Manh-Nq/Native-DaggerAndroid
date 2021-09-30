package com.example.dependencynow.module.sub

import com.example.dependencynow.screens.main.MainActivity
import com.example.dependencynow.screens.splash.SplashActivity
import com.example.dependencynow.screens.splash.SplashViewModel
import dagger.Component
import dagger.Provides
import dagger.Subcomponent

@SplScope
@Subcomponent
interface SplashComponent {

    fun getViewModel(): SplashViewModel
    fun inject(activity: SplashActivity)

    @Subcomponent.Factory
    interface FactoryComponent {
        fun create(): SplashComponent
    }
}