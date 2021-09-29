package com.example.dependencynow.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val name: String,
    val age: Int
)