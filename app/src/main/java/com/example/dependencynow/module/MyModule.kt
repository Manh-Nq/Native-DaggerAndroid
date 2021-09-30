package com.example.dependencynow.module

import android.app.Application
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import dagger.Module
import dagger.Provides

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