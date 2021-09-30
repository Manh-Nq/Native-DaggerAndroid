package com.example.dependencynow.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dependencynow.Utils
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.database.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val personDao: PersonDao) : ViewModel() {

     val _data = personDao.getAll().asLiveData()

    fun insert() {
        viewModelScope.launch {
            personDao.insert(Utils.randomPerson())
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            personDao.deleteAll()
        }
    }

    fun delete(item: Person) {
        viewModelScope.launch {
            personDao.delete(item.id)
        }
    }

}