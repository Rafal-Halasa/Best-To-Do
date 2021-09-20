package com.example.besttodo.logic.extensions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.logic.extensions.Actions.ADD_TASK
import org.koin.java.KoinJavaComponent.inject

fun Fragment.observeActions(viewModel: ViewModel) {
    viewModel.action().observe(viewLifecycleOwner, {
        when (it) {
            ADD_TASK -> TODO()
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