package com.example.besttodo.data.data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.besttodo.data.models.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table")
    fun getToDoes(): Flow<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: ToDo)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()
}