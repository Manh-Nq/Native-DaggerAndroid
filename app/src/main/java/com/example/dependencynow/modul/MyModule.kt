//package com.example.dependencynow.modul
//
//import android.app.Application
//import com.example.dependencynow.database.dao.PersonDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class MyModule {
//
//    @Provides
//    @Singleton
//    fun provideDataBase(application: Application) = PersonDatabase.builder(application)
//
//    @Provides
//    @Singleton
//    fun provideDao(personDatabase: PersonDatabase) = personDatabase.personDao
//
//
//}