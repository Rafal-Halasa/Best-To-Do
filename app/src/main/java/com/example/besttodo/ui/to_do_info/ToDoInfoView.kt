package com.example.besttodo.ui.to_do_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.besttodo.databinding.LayoutToDoInfoBinding
import com.example.besttodo.logic.extensions.observeActions
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject

class ToDoInfoView : Fragment() {
    private val args: ToDoInfoViewArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        observeActions()
        val layout: LayoutToDoInfoBinding by inject { parametersOf(inflater, container) }
        layout.toDo = args.toDo
        return layout.root
    }
}