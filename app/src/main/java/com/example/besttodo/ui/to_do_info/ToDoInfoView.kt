package com.example.besttodo.ui.to_do_info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.besttodo.databinding.LayoutToDoInfoBinding
import com.example.besttodo.logic.extensions.observeActions
import org.koin.java.KoinJavaComponent.inject

class ToDoInfoView : Fragment() {
    private val viewModel: ToDoInfoViewModel by inject(ToDoInfoViewModel::class.java)
    val args: ToDoInfoViewArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        observeActions()
        Log.e("tutaj", args.toString())
        val inflate = LayoutToDoInfoBinding.inflate(inflater, container, false)
        inflate.viewModel = viewModel
        return inflate.root
    }
}