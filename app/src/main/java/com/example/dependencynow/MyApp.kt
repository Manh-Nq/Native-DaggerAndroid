package com.example.dependencynow

import android.app.Application
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    lateinit var instance: MyApp

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}