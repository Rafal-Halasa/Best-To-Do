package com.example.besttodo.logic.services

import androidx.lifecycle.LiveData
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.data.repositories.ToDoRepositoryI
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ToDoListService : ToDoListServiceI, KoinComponent {
    private val todoRepository: ToDoRepositoryI by inject()
    override val allToDo: LiveData<List<ToDo>> = todoRepository.allToDo
    override suspend fun insertToDo(text: String) {
        todoRepository.insertToDo(ToDo(text))
    }
}

interface ToDoListServiceI {
    val allToDo: LiveData<List<ToDo>>
    suspend fun insertToDo(text: String)
}