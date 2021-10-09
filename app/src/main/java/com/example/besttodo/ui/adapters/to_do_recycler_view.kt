package com.example.besttodo.ui.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.ui.to_do_list.ToDoListItemClickListener
import com.example.besttodo.ui.to_do_list.components.ToDoListAdapter
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject

@BindingAdapter(value = ["todos", "onClickTaskListener"], requireAll = false)
fun setTodos(recyclerView: RecyclerView, todos: List<ToDo>, onClickListener: ToDoListItemClickListener) {
    if (recyclerView.adapter == null) {
        val toDoListAdapter: ToDoListAdapter by inject(ToDoListAdapter::class.java) { parametersOf(todos, onClickListener) }
        recyclerView.adapter = toDoListAdapter
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 1)
    }
}