//package com.example.dependencynow.modul
//
//import android.app.Application
//import com.example.dependencynow.database.dao.PersonDao
//import com.example.dependencynow.database.dao.PersonDatabase
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class AppModule {
//
//    @Singleton
//    @Provides
//    fun provideDatabase(application: Application): PersonDatabase {
//        return PersonDatabase.builder(application)
//    }
//
//    @Singleton
//    @Provides
//    fun provideDao(database: PersonDatabase): PersonDao {
//        return database.personDao
//    }
//
//}