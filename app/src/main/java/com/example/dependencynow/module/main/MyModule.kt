package com.example.dependencynow.module.main

import android.app.Application
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.module.sub.SplashComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [SplashComponent::class])
class MyModule {

    @Singleton
    @Provides
    fun provideDataBase(application: Application): PersonDatabase {
        return PersonDatabase.builder(application)
    }

    @Singleton
    @Provides
    fun provideDao(personDatabase: PersonDatabase): PersonDao {
        return personDatabase.personDao
    }


}