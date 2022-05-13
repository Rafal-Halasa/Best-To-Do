package com.example.besttodo.ui.adapters

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.ui.to_do_list.ToDoListItemClickListener
import com.example.besttodo.ui.to_do_list.components.ToDoListAdapter
import org.koin.java.KoinJavaComponent.inject

@BindingAdapter(value = ["todos", "onClickItemListener"], requireAll = false)
fun setTodos(recyclerView: RecyclerView, todos: LiveData<List<ToDo>>, onClickItemListener: ToDoListItemClickListener? = null) {
    val toDoListAdapter: ToDoListAdapter by inject(ToDoListAdapter::class.java)
    toDoListAdapter.todos = todos.value
    if (recyclerView.adapter == null) {
        onClickItemListener?.let { toDoListAdapter.onClickListener = onClickItemListener }
        recyclerView.adapter = toDoListAdapter
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 1)
    } else {
        todos.value?.let {
            toDoListAdapter.notifyItemChanged(it.size)
        }
    }
}
