package com.example.dependencynow

import android.app.Application
import com.example.dependencynow.module.DaggerMyComponent
import com.example.dependencynow.module.MyComponent


class MyApp : Application() {
//    lateinit var personDB: PersonDatabase

    lateinit var instance: MyApp
    lateinit var component: MyComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerMyComponent.builder().createApplication(this).build()
//        personDB = PersonDatabase.builder(instance)
    }
}