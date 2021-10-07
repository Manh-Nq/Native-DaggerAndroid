package com.example.dependencynow.modul

import com.example.dependencynow.modul.example.CustomComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Named

@Module
@InstallIn(CustomComponent::class)
class CustomModule {
    @Provides
    @Named("number")
    fun provideNumber() = 123

}