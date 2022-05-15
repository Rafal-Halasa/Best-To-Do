package com.example.besttodo.data.data_base

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.besttodo.data.models.ToDo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.get

@RunWith(AndroidJUnit4::class)
class DataBaseTest : KoinTest {
    private lateinit var db: TestDataBase

    @Before
    fun createDb() {
        db = get()
        db.clearAllTables()
    }

    @Test
    @Throws(Exception::class)
    fun writeTodo() = runBlocking {
        val todoDao = db.todoDao
        val toDo = listOf(ToDo("das"))
        todoDao.insert(toDo[0])
        val value = todoDao.getToDoes().first()

        assertThat(toDo, equalTo(value))
    }

    @Test
    @Throws(Exception::class)
    fun writeManyTodo() = runBlocking {
        val todoDao = db.todoDao
        val toDo = listOf(ToDo("das"), ToDo("dass"), ToDo("dasss"))
        todoDao.insert(toDo[0])
        todoDao.insert(toDo[1])
        todoDao.insert(toDo[2])
        val value = todoDao.getToDoes().first()
        assertThat(toDo, equalTo(value))
    }
    @Test
    @Throws(Exception::class)
    fun writeTheSameTodo() = runBlocking {
        val todoDao = db.todoDao
        val toDo = listOf(ToDo("das"))
        todoDao.insert(toDo[0])
        todoDao.insert(toDo[0])
        todoDao.insert(toDo[0])
        val value = todoDao.getToDoes().first()
        assertThat(toDo, equalTo(value))
    }
}