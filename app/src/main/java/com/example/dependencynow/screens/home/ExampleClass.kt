package com.example.dependencynow.screens.home

import com.example.dependencynow.database.dao.PersonDao
import com.example.dependencynow.database.dao.PersonDatabase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

@AssistedFactory
interface ExampleClassFactory{
    fun create(@Assisted("id1") id: Int, @Assisted("id2")  id2: Int): ExampleClass
}

class ExampleClass @AssistedInject constructor(val database: PersonDatabase, val dao: PersonDao, @Assisted("id2") val id: Int, @Assisted("id1") val id2: Int) {
}