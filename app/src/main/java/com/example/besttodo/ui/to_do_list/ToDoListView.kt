package com.example.besttodo.ui.to_do_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.besttodo.databinding.LayoutToDoListBinding
import com.example.besttodo.logic.extensions.observeActions
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ToDoListView : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        observeActions()
        val layout: LayoutToDoListBinding by inject { parametersOf(inflater, container) }
        layout.lifecycleOwner = this
        return layout.root
    }
}