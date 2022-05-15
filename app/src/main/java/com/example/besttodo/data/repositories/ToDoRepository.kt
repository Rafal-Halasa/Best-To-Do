package com.example.besttodo.data.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.besttodo.data.data_base.dao.ToDoDao
import com.example.besttodo.data.models.ToDo
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent.inject

class ToDoRepository : ToDoRepositoryI {
    private val todoDao: ToDoDao by inject(ToDoDao::class.java)

    override val allToDo = todoDao.getToDoes().asLiveData()

    @WorkerThread
    override suspend fun insertToDo(toDo: ToDo) {
        todoDao.insert(toDo)
    }
}

interface ToDoRepositoryI {
    val allToDo: LiveData<List<ToDo>>
    suspend fun insertToDo(toDo: ToDo)
}