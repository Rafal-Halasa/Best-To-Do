package com.example.besttodo.ui.to_do_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.besttodo.databinding.LayoutToDoListBinding
import org.koin.java.KoinJavaComponent

class ToDoListView : Fragment(), ToDoListViewI {
    private val tooDoListViewModel: ToDoListViewModelI by KoinJavaComponent.inject(ToDoListViewModel::class.java)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val inflate = LayoutToDoListBinding.inflate(inflater, container, false)
        inflate.viewModel = tooDoListViewModel
        return inflate.root
    }
}

interface ToDoListViewI {

}