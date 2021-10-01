package com.example.dependencynow.modul.main

import android.app.Application
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.modul.CustomComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CustomComponent::class])
class MyModule {

    @Provides
    @Singleton
    fun providePersonDataBase(application: Application) = PersonDatabase.builder(application)

    @Provides
    @Singleton
    fun providePersonDao(personDatabase: PersonDatabase) = personDatabase.personDao


}