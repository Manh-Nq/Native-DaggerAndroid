package com.example.dependencynow.modul.example

import com.example.dependencynow.modul.example.CustomComponent
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.hilt.InstallIn
import javax.inject.Named

@Module
@InstallIn(CustomComponent::class)
class CustomModule {
}