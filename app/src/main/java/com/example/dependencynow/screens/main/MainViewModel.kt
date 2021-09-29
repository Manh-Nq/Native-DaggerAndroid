package com.example.dependencynow.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.database.model.Person
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class MainViewModelFactory(val dataBase: PersonDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataBase) as T
        }
        throw IllegalArgumentException("not support type")
    }
}

class MainViewModel(dataBase: PersonDatabase) : ViewModel() {
    val personDao = dataBase.personDao
    val _data = personDao.getAll().asLiveData()


    fun insert(name: String, age: Int) {
        viewModelScope.launch {
            personDao.insert(Person(name = name, age = age))
        }
    }

}