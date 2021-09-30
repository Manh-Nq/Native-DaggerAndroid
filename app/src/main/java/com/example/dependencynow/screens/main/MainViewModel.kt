package com.example.dependencynow.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dependencynow.Utils
import com.example.dependencynow.Utils.Companion.devideTxt
import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import com.example.dependencynow.database.model.Person
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject


//class MainViewModelFactory(val dataBase: PersonDatabase) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(dataBase) as T
//        }
//        throw IllegalArgumentException("not support type")
//    }
//}

class MainViewModel @Inject constructor(val dataDao: PersonDao) : ViewModel() {

    val _data = dataDao.getAll().asLiveData()


    fun insert(txt: String) {
        viewModelScope.launch {
            dataDao.insert(Utils.randomPerson(txt.devideTxt()))
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            dataDao.deleteAll()
        }
    }

}