package com.example.dependencynow.modul.example

import android.app.Application
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.modul.example.CustomComponent
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.hilt.InstallIn
import javax.inject.Named

@Module
@InstallIn(CustomComponent::class)
class CustomModule {

    @Provides
    @Named("String1")
    fun provideString() = "This is String 1"


}