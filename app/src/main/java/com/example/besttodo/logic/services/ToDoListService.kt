package com.example.besttodo.logic.services

import com.example.besttodo.data.models.ToDo
import com.example.besttodo.data.repositories.ToDoRepository
import com.example.besttodo.data.repositories.ToDoRepositoryI
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class ToDoListService : ToDoListServiceI {
    private val todoListService: ToDoRepositoryI by KoinJavaComponent.inject(ToDoRepository::class.java)
    override val allToDo: Flow<List<ToDo>> = todoListService.allToDo

    override suspend fun insertToDo(toDo: ToDo) {
        todoListService.insertToDo(toDo)
    }

}

interface ToDoListServiceI {
    val allToDo: Flow<List<ToDo>>
    suspend fun insertToDo(toDo: ToDo)
}