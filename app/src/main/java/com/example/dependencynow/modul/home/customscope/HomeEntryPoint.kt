package com.example.dependencynow.modul.home.customscope

import androidx.lifecycle.LiveData
import com.example.dependencynow.database.model.Person
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@InstallIn(HomeComponent::class)
@EntryPoint
interface HomeEntryPoint {
    fun getPerson(): LiveData<List<Person>>
}