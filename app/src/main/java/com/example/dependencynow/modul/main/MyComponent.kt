package com.example.dependencynow.modul.main

import android.app.Application
import com.example.dependencynow.modul.CustomComponent
import com.example.dependencynow.screens.main.MainActivity
import com.example.dependencynow.screens.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [MyModule::class])
interface MyComponent {

    fun createCustomComponent(): CustomComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun attachApplication(application: Application): Builder

        fun build(): MyComponent

    }


}