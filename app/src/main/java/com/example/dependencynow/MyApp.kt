package com.example.dependencynow

import android.app.Application
import com.example.dependencynow.modul.main.DaggerMyComponent
import com.example.dependencynow.modul.main.MyComponent


class MyApp : Application() {
    lateinit var component: MyComponent
    lateinit var instance: MyApp

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerMyComponent.builder().attachApplication(this)
            .attachInt(0).build()
    }
}