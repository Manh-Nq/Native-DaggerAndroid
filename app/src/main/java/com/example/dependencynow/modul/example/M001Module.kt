package com.example.dependencynow.modul.example

import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import javax.inject.Named

@Module
@InstallIn(M001Component::class)
class M001Module {
//    @Provides
//    @Named("Person")
//    fun providePerson(component: M001Component) =
//        EntryPoints.get(component, M001EntryPoint::class.java).getPerson()
}