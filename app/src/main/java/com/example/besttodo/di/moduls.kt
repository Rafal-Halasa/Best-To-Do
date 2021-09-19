package com.example.besttodo.di

import com.example.besttodo.logic.services.ToDoListService
import com.example.besttodo.ui.to_do_list.ToDoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { ToDoListService()}
    viewModel { ToDoListViewModel() }
}