package com.example.besttodo.logic.extensions

import androidx.annotation.IdRes
import androidx.navigation.NavController

fun NavController.safeNavigate(@IdRes actionId: Int) {
    if (this.currentDestination?.getAction(actionId) != null)
        this.navigate(actionId)
}