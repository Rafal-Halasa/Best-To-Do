package com.example.besttodo.logic.services

import com.example.besttodo.data.models.ToDo
import com.example.besttodo.data.repositories.ToDoRepositoryI
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class ToDoListService : ToDoListServiceI {
    private val todoRepository: ToDoRepositoryI by KoinJavaComponent.inject(ToDoRepositoryI::class.java)
    override val allToDo: Flow<List<ToDo>> = todoRepository.allToDo
    override suspend fun insertToDo(text: String) {
        todoRepository.insertToDo(ToDo(text))
    }

    fun test() {
    }
}

interface ToDoListServiceI {
    val allToDo: Flow<List<ToDo>>
    suspend fun insertToDo(text: String)
}