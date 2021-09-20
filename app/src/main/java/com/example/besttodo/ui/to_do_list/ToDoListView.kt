package com.example.besttodo.ui.to_do_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.besttodo.databinding.LayoutToDoListBinding
import com.example.besttodo.logic.extensions.observeActions
import org.koin.java.KoinJavaComponent.inject

class ToDoListView : Fragment() {
    private val viewModel: ToDoListViewModel by inject(ToDoListViewModel::class.java)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        observeActions(viewModel)
        val inflate = LayoutToDoListBinding.inflate(inflater, container, false)
        inflate.viewModel = viewModel
        return inflate.root
    }
}