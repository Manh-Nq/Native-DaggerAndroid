package com.example.dependencynow.modul.example

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent

@CustomScope
@DefineComponent(parent = ActivityRetainedComponent::class)
public interface CustomComponent {

    @DefineComponent.Builder
    interface Builder {
        fun build(): CustomComponent
    }
}