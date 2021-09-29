package com.example.dependencynow.database.dao

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.*
import com.example.dependencynow.database.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert
    suspend fun insert(item: Person)

    @Update
    suspend fun update(item: Person)

    @Query("SELECT * FROM person")
    fun getAll(): Flow<List<Person>>

    @Query("DELETE FROM person WHERE id= :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM person")
    suspend fun deleteAll()

}

@Database(entities = [Person::class], exportSchema = false, version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract val personDao: PersonDao

    companion object {
        fun builder(context: Context): PersonDatabase {
            return Room.databaseBuilder(context, PersonDatabase::class.java, "person").build()
        }
    }
}