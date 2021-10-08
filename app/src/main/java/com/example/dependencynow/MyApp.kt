package com.example.dependencynow

import android.app.Application
import com.example.dependencynow.modul.example.CustomComponent
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApp : Application() {
    lateinit var instance: MyApp


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}