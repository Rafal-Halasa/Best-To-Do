package com.example.besttodo.logic.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.besttodo.R
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.logic.extensions.Actions.ADD_TASK
import org.koin.java.KoinJavaComponent.inject

fun Fragment.observeActions(viewModel: ViewModel) {
    viewModel.action().observe(viewLifecycleOwner, {
        when (it) {
            ADD_TASK -> findNavController().safeNavigate(R.id.action_toDoListView_to_toDoCreateView)
            else -> TODO()
        }
    })
}

fun ViewModel.action(): SingleLiveData<Actions> {
    val action: SingleLiveData<Actions> by inject(SingleLiveData::class.java)
    return action
}

enum class Actions {
    ADD_TASK
}