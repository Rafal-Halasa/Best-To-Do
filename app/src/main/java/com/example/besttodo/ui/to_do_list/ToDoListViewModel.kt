package com.example.besttodo.ui.to_do_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.logic.extensions.Actions
import com.example.besttodo.logic.extensions.action
import com.example.besttodo.logic.services.ToDoListServiceI
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ToDoListViewModel : ViewModel(), ToDoListViewModelI, KoinComponent {
    private val todoListService: ToDoListServiceI by inject()

    override val toDoList: LiveData<List<ToDo>> = MutableLiveData<List<ToDo>>().apply {
        viewModelScope.launch {
            todoListService.allToDo.collect {
                value = it
            }
        }

    }


    override fun addToDo() {

    }

    override fun addToDo(text: String) {
        viewModelScope.launch { todoListService.insertToDo(text) }
    }

    override fun onItemClick(toDo: ToDo) {
        action().value = Actions.TO_DO_INDO
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