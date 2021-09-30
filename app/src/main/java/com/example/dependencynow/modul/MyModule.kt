package com.example.dependencynow.modul

import android.app.Application
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyModule {

    @Provides
    fun provideDataBase(application: Application): PersonDatabase {
        return PersonDatabase.builder(application)
    }
    @Provides
    fun provideDao(personDatabase: PersonDatabase): PersonDao {
        return personDatabase.personDao
    }


}