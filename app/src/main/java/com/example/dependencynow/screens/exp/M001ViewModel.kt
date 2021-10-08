package com.example.dependencynow.screens.exp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.modul.example.M001Component
import com.example.dependencynow.modul.example.M001EntryPoint
import dagger.hilt.EntryPoints
import javax.inject.Inject
import javax.inject.Named


class M001ViewModel @Inject constructor() : ViewModel() {
    var _data: MutableLiveData<Person> = MutableLiveData()


    fun getComponent(component: M001Component) {
        _data.value = EntryPoints.get(component, M001EntryPoint::class.java).getPerson()
    }
}