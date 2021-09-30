package com.example.dependencynow.module.main

import android.app.Application
import com.example.dependencynow.module.sub.SplashComponent
import com.example.dependencynow.screens.main.MainActivity
import com.example.dependencynow.screens.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyModule::class])
interface MyComponent {
    fun getMainModel(): MainViewModel

    fun inject(activity: MainActivity)

    fun getSplashComponent(): SplashComponent.FactoryComponent


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun createApplication(application: Application): Builder

        fun build(): MyComponent
    }

}