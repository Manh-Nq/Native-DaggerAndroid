package com.example.dependencynow.screens.main

import androidx.lifecycle.*
import com.example.dependencynow.Utils
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.database.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Named
import kotlin.time.days

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    //    val _data = personDao.getAll().asLiveData()
    var _num: MutableLiveData<String> = MutableLiveData<String>()

    init {
        _num.value = "hello"
    }

    fun insert() {
        viewModelScope.launch {
//            personDao.insert(Utils.randomPerson())
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
//            personDao.deleteAll()
        }
    }

    fun delete(item: Person) {
        viewModelScope.launch {
//            personDao.delete(item.id)
        }
    }

}