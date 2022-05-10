package com.example.besttodo.logic.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.data.models.ToDo
import com.example.besttodo.logic.extensions.GoTo.TO_DO_INFO
import com.example.besttodo.ui.to_do_list.ToDoListViewDirections
import org.koin.java.KoinJavaComponent.inject

fun Fragment.observeActions() {
    ActionNavigator.action.observe(viewLifecycleOwner) {
        when (it.goto) {
            TO_DO_INFO -> findNavController().navigate(ToDoListViewDirections.actionToDoListViewToToDoInfoView(it.tes as ToDo))
        }
    }
}

fun ViewModel.goToAction(actions: Actions<Any>) {
    ActionNavigator.action.value = actions
}

object ActionNavigator {
    val action: SingleLiveData<Actions<Any>> by inject(SingleLiveData::class.java)
}

data class Actions<T>(val tes: T, val goto: GoTo)

enum class GoTo {
    TO_DO_INFO
}