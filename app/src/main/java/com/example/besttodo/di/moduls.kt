package com.example.besttodo.di

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.room.Room
import com.example.besttodo.data.base.SingleLiveData
import com.example.besttodo.data.data_base.ToDoDataBase
import com.example.besttodo.data.data_base.dao.ToDoDao
import com.example.besttodo.data.repositories.ToDoRepository
import com.example.besttodo.data.repositories.ToDoRepositoryI
import com.example.besttodo.databinding.LayoutToDoListBinding
import com.example.besttodo.logic.extensions.Actions
import com.example.besttodo.logic.services.ToDoListService
import com.example.besttodo.logic.services.ToDoListServiceI
import com.example.besttodo.ui.to_do_info.ToDoCreateViewModel
import com.example.besttodo.ui.to_do_list.ToDoListViewModel
import com.example.besttodo.ui.to_do_list.components.ToDoListAdapter
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { SingleLiveData<Actions>() }
}

val viewModelsModules = module {
    viewModel { ToDoListViewModel() }
    viewModel { ToDoCreateViewModel() }
}

val dbModules = module {
    single { createDB(androidApplication()) }
    single { createDao(get()) }
}
val servicesModules = module {
    single<ToDoListServiceI> { ToDoListService() }
}
val repositoriesModules = module {
    single<ToDoRepositoryI> { ToDoRepository() }
}

val adapters = module {
    single { ToDoListAdapter() }
}
val viewBinding = module {
    factory { createToDoListLayout(get(), get()) }
}

fun createToDoListLayout(inflater: LayoutInflater, container: ViewGroup?): LayoutToDoListBinding =
    LayoutToDoListBinding.inflate(inflater, container, false)

fun createDao(db: ToDoDataBase): ToDoDao = db.todoDao

fun createDB(application: Application): ToDoDataBase {
    return Room.databaseBuilder(
        application,
        ToDoDataBase::class.java,
        "todo_data_database"
    ).build()
}
