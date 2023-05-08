package kgb.plum.composearchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kgb.plum.composearchitecture.ui.theme.ComposeArchitectureTheme


@AndroidEntryPoint
class HiltActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RepoScreen()
                }
            }
        }
    }
}

@Composable
fun RepoScreen(
    viewModel: GithubViewModel = viewModel()
){
    LazyColumn {
        item {
            Button(onClick = {
                viewModel.getRepos()
            }){
                Text("레포지토리 가져오기")
            }
        }
        items(viewModel.repos) {item ->
            Card(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = item.name)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeArchitectureTheme {
        RepoScreen()
    }
}