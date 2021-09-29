package com.example.dependencynow

import android.app.Application
import com.example.dependencynow.database.dao.PersonDatabase
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class MyApp : Application() {
    lateinit var personDB: PersonDatabase

    lateinit var instance: MyApp

    override fun onCreate() {
        super.onCreate()
        instance = this
        personDB = PersonDatabase.builder(instance)
    }
}