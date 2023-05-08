package kgb.plum.composearchitecture

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kgb.plum.composearchitecture.data.TodoData

class TodoViewModel: ViewModel() {
    val id = mutableStateOf(1)
    val content = mutableStateOf("")
    val todoList = mutableStateListOf<TodoData>()


    fun onToggle(id : Int) {
        val index = todoList.indexOfFirst { it.id == id }
        todoList[index] = todoList[index].copy(done = !todoList[index].done)
    }

    fun onDelete(id : Int) {
        val index = todoList.indexOfFirst { it.id == id}
        todoList.removeAt(index)
    }

    fun onEdit(id : Int, content : String) {
        val index = todoList.indexOfFirst { it.id == id }
        todoList[index] = todoList[index].copy(content = content)
    }

    fun onSubmit(content: String) {
        todoList.add(TodoData(id.value, content))
        id.value.plus(1)
    }
}