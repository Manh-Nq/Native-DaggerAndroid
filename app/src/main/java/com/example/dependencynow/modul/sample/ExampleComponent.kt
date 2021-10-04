package com.example.dependencynow.modul.sample

import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@DefineComponent(parent = ActivityRetainedComponent::class)
interface ExampleComponent {

    @DefineComponent.Builder
    interface Builder {
        fun setNum(num: Int): Builder
        fun build(): ExampleComponent
    }
}