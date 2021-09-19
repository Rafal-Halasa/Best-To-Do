package com.example.besttodo.ui.to_do_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.besttodo.data.ToDo
import com.example.besttodo.logic.services.ToDoListService
import com.example.besttodo.logic.services.ToDoListServiceI
import org.koin.java.KoinJavaComponent.inject

class ToDoListViewModel : ViewModel(), ToDoListViewModelI {
    val todoListService: ToDoListServiceI by inject(ToDoListService::class.java)

    override val toDoList: MutableLiveData<ToDo> by lazy { MutableLiveData<ToDo>() }
    override fun loadTodoList() {

    }

    override fun addToDo() {

    }

}

interface ToDoListViewModelI {
    val toDoList: MutableLiveData<ToDo>
    fun loadTodoList()
    fun addToDo()
}