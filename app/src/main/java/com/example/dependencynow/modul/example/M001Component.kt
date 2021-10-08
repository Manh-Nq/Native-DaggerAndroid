package com.example.dependencynow.modul.example

import com.example.dependencynow.database.model.Person
import dagger.BindsInstance
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Named


@M001Scope
@DefineComponent(parent = ActivityRetainedComponent::class)
interface M001Component {

    @DefineComponent.Builder
    interface Builder {
        fun attachNumber(@BindsInstance @Named("Person") person: Person): Builder
        fun build(): M001Component
    }
}

@EntryPoint
@InstallIn(M001Component::class)
interface M001EntryPoint {
    @Named("Person")
    fun getPerson(): Person
}