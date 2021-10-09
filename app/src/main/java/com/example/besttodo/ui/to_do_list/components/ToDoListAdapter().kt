package com.example.besttodo.ui.to_do_list.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.databinding.ItemListToDoBinding
import com.example.besttodo.ui.to_do_list.ToDoListItemClickListener

class ToDoListAdapter(
    var onClickListener: ToDoListItemClickListener? = null,
    var todos: List<ToDo> = listOf()
) : RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {


    class ViewHolder(private val viewBinding: ItemListToDoBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(todo: ToDo) {
            viewBinding.todo = todo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemListToDoBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size
}