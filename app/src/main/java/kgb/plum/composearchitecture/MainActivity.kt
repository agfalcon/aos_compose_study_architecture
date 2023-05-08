package kgb.plum.composearchitecture

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.composearchitecture.data.TodoData
import kgb.plum.composearchitecture.ui.theme.ComposeArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoList()
                }
            }
        }
    }
}

@Composable
fun TodoList(){

}

@Composable
fun InputData(
    content: String,
    setContent: (String) -> Unit = {_ ->},
    onSubmit: (String) -> Unit = {_ ->}
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = content,
            onValueChange = setContent
        )
        Spacer(modifier = Modifier.size(6.dp))
        Button(
            onClick = { onSubmit(content) }
        ) {
            Text("입력")
        }
    }
}

@Composable
fun TodoItem(
    todoData: TodoData,
    onToggle: (Int) -> Unit = {_ ->},
    onDelete: (Int) -> Unit = {_ ->},
    onEdit: (Int, String) -> Unit = {_, _ ->}
){
    var isEdit by remember{mutableStateOf(false)}
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
        Crossfade(targetState = isEdit) {
            when(it) {
                false -> {
                    Row(
                        modifier = Modifier.padding(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = todoData.content,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "완료"
                        )
                        Checkbox(
                            checked = todoData.done,
                            onCheckedChange = {onToggle(todoData.id)}
                        )
                        Button(onClick = {isEdit = true}) {
                            Text("수정")
                        }
                        Button(onClick = {onDelete(todoData.id)}) {
                            Text("삭제")
                        }
                    }
                }
                true -> {
                    val (text, setText) = remember{mutableStateOf("")}
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        OutlinedTextField(
                            value = text,
                            onValueChange = setText
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Button(
                            onClick = { onEdit(todoData.id, text) }
                        ) {
                            Text("수정")
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArchitectureTheme {
        TodoList()
    }
}

@Preview(showBackground = true)
@Composable
fun InputDataPreview(){
    ComposeArchitectureTheme {
        InputData("")
    }
}

@Preview(showBackground = true)
@Composable
fun TodoDataPreview(){
    ComposeArchitectureTheme {
        TodoItem(
            TodoData(1, "abc", false)
        )
    }
}