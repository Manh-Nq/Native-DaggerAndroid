package com.example.dependencynow.modul.home

import com.example.dependencynow.screens.home.HomeViewModel
import dagger.assisted.AssistedFactory

@AssistedFactory
interface HomeFactory {
    fun create(noteId: String): HomeViewModel
}