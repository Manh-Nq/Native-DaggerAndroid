package com.example.dependencynow.modul

import android.app.Application
import com.example.dependencynow.screens.main.MainActivity
import com.example.dependencynow.screens.main.MainViewModel
import dagger.BindsInstance
import dagger.Component


@Component(modules = [MyModule::class])
interface MyComponent {
    fun getMainModel(): MainViewModel

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun createApplication(application: Application): Builder

        fun build(): MyComponent
    }

}