package com.example.besttodo.ui.to_do_list.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.databinding.ItemListToDoBinding
import com.example.besttodo.ui.to_do_list.ToDoListItemClickListener

class ToDoListAdapter : RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    var onClickListener: ToDoListItemClickListener? = null
    var todos: List<ToDo>? = null

    class ViewHolder(private val viewBinding: ItemListToDoBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(todo: ToDo, onClickListener: ToDoListItemClickListener?) {
            viewBinding.todo = todo
            viewBinding.listener = onClickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemListToDoBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        todos?.let { holder.bind(it[position], onClickListener) }
    }

    override fun getItemCount(): Int = todos?.size ?: 0
}