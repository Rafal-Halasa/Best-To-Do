package com.example.besttodo.ui.to_do_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.logic.extensions.Actions
import com.example.besttodo.logic.extensions.action
import com.example.besttodo.logic.services.ToDoListService
import com.example.besttodo.logic.services.ToDoListServiceI
import org.koin.java.KoinJavaComponent.inject

class ToDoListViewModel : ViewModel(), ToDoListViewModelI {
    private val todoListService: ToDoListServiceI by inject(ToDoListService::class.java)

    override val toDoList: LiveData<List<ToDo>> = todoListService.allToDo.asLiveData()


    override fun addToDo() {
        action().value = Actions.ADD_TASK
    }

}

interface ToDoListViewModelI {
    val toDoList: LiveData<List<ToDo>>
    fun addToDo()
}