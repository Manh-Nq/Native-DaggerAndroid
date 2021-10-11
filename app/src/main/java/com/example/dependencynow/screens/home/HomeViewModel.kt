package com.example.dependencynow.screens.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.modul.home.SingleScope
import javax.inject.Inject
import javax.inject.Named

const val TAG = "ManhNQ"

class HomeViewModel @Inject constructor(@Named("your_name") txt: String) : ViewModel() {

    var _data = MutableLiveData<String>()

    init {
        _data.value = txt
    }
}
