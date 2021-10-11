package com.example.besttodo.logic.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.logic.extensions.GoTo.TO_DO_INFO
import com.example.besttodo.ui.to_do_list.ToDoListViewDirections
import org.koin.java.KoinJavaComponent.inject

fun Fragment.observeActions(viewModel: ViewModel) {
    viewModel.action().observe(viewLifecycleOwner, {
        val tes = it.tes
        when (it.goto) {
            TO_DO_INFO -> findNavController().navigate(ToDoListViewDirections.actionToDoListViewToToDoInfoView(it.tes as ToDo))
        }
    })
}

fun ViewModel.action(): SingleLiveData<Actions<Any?>> {
    val action: SingleLiveData<Actions<Any?>> by inject(SingleLiveData::class.java)
    return action
}

data class Actions<T>(val tes: T, val goto: GoTo)

enum class GoTo {
    TO_DO_INFO
}