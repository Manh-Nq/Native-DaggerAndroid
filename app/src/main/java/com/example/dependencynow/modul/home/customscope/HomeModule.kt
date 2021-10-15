package com.example.dependencynow.modul.home.customscope

import androidx.lifecycle.asLiveData
import com.example.dependencynow.database.dao.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(HomeComponent::class)
object HomeModule {

    @Provides
    @HomeScope
    fun provideUserDetails(dao: PersonDao) = dao.getAll().asLiveData()

}