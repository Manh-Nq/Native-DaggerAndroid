package com.example.dependencynow.modul.home.customscope

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent

@HomeScope
@DefineComponent(parent = ActivityRetainedComponent::class)
interface HomeComponent {
    @DefineComponent.Builder
    interface Builder {
        fun create(): HomeComponent
    }
}