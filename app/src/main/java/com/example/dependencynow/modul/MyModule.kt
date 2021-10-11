package com.example.dependencynow.modul

import android.app.Application
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.modul.home.HomeComponent
import com.example.dependencynow.modul.home.HomeModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module(includes = [HomeModule::class])
@InstallIn(ActivityRetainedComponent::class)
 class MyModule {

   @Provides
   fun provideDataBase(application: Application) = PersonDatabase.builder(application)

   @Provides
   fun provideDao(personDatabase: PersonDatabase) = personDatabase.personDao
}