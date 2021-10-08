package com.example.dependencynow.modul.example

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@CustomScope
@DefineComponent(parent = ActivityRetainedComponent::class)
interface CustomComponent {


}