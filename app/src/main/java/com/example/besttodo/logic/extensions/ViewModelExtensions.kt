package com.example.besttodo.logic.extensions

import androidx.fragment.app.Fragment
import com.example.besttodo.logic.extensions.Actions.ADD_TASK

fun Fragment.startAction(actions: Actions) {
    when (actions) {
        ADD_TASK -> TODO()
        else -> TODO()
    }
}

enum class Actions {
    ADD_TASK
}