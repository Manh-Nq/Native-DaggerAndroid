package com.example.dependencynow.modul.home.customscope

import com.example.dependencynow.database.model.Person
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(HomeComponent::class)
class HomeModule {

    @Provides
    @HomeScope
    fun provideUserDetails(): Person {
        return Person(name = "manh", age = 25)
    }
}