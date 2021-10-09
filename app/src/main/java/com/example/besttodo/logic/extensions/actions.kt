package com.example.besttodo.logic.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.besttodo.R
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.logic.extensions.Actions.TO_DO_INDO
import org.koin.java.KoinJavaComponent.inject

fun Fragment.observeActions(viewModel: ViewModel) {
    viewModel.action().observe(viewLifecycleOwner, {
        when (it) {
            TO_DO_INDO -> findNavController().safeNavigate(R.id.action_toDoListView_to_toDoCreateView)
            else -> TODO()
        }
    })
}

fun ViewModel.action(): SingleLiveData<Actions> {
    val action: SingleLiveData<Actions> by inject(SingleLiveData::class.java)
    return action
}

enum class Actions {
    TO_DO_INDO
}