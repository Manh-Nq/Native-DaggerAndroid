package com.example.dependencynow

import android.app.Application
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.modul.example.M001Component
import com.example.dependencynow.modul.example.M001EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    lateinit var instance: MyApp

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

//    fun getComponent(component: M001Component): Person {
//        return EntryPoints.get(component, M001EntryPoint::class.java).getPerson()
//    }

}