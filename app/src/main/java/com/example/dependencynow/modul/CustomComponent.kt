package com.example.dependencynow.modul

import com.example.dependencynow.screens.main.MainActivity
import com.example.dependencynow.screens.main.MainViewModel
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@MyScope
@Subcomponent
interface CustomComponent {
    fun getMainViewModel(): MainViewModel

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Factory {
        @BindsInstance
        fun createInt(@Named("num") num: Int):Factory
        fun build(): CustomComponent
    }
}