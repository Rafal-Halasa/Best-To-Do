package com.example.besttodo.ui.to_do_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.logic.extensions.Actions
import com.example.besttodo.logic.extensions.GoTo
import com.example.besttodo.logic.extensions.goToAction
import com.example.besttodo.logic.services.ToDoListServiceI
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ToDoListViewModel : ViewModel(), ToDoListViewModelI, KoinComponent {
    private val todoListService: ToDoListServiceI by inject()


    override val toDoList: LiveData<List<ToDo>> = todoListService.allToDo

    override fun addToDo() {

    }

    override fun addToDo(text: String) {
        viewModelScope.launch { todoListService.insertToDo(text) }
    }

    override fun onItemClick(toDo: ToDo) {
        goToAction(Actions(toDo, GoTo.TO_DO_INFO))
    }

}

interface ToDoListViewModelI : ToDoListItemClickListener {
    val toDoList: LiveData<List<ToDo>>
    fun addToDo()
    fun addToDo(text: String)
}

interface ToDoListItemClickListener {
    fun onItemClick(toDo: ToDo)
}