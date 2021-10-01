package com.example.dependencynow.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dependencynow.Utils
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.database.model.Person
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Named

//
//class MainViewModelFactory(val dataBase: PersonDatabase) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(dataBase) as T
//        }
//        throw IllegalArgumentException("not support type")
//    }
//}

class MainViewModel @Inject constructor
    (private val dao: PersonDao, @Named("num") val num: Int) :
    ViewModel() {

    val _data = dao.getAll().asLiveData()


    fun insert() {
        viewModelScope.launch {
            dao.insert(Utils.randomPerson())
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            dao.deleteAll()
        }
    }

    fun delete(item: Person) {
        viewModelScope.launch {
            dao.delete(item.id)
        }
    }

}