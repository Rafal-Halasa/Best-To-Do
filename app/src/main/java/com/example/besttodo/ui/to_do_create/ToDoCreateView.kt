package com.example.besttodo.ui.to_do_create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.besttodo.databinding.LayoutToDoCreateBinding
import com.example.besttodo.logic.extensions.observeActions
import org.koin.java.KoinJavaComponent.inject

class ToDoCreateView : Fragment() {
    private val viewModel: ToDoCreateViewModel by inject(ToDoCreateViewModel::class.java)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        observeActions(viewModel)
        val inflate = LayoutToDoCreateBinding.inflate(inflater, container, false)
        inflate.viewModel = viewModel
        return inflate.root
    }
}