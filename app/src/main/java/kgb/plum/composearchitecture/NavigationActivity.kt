package kgb.plum.composearchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kgb.plum.composearchitecture.ui.theme.ComposeArchitectureTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                     naviEx()
                }
            }
        }
    }
}

@Composable
fun naviEx(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(navController, "Home", modifier = modifier) {
        composable("Home"){
            Column{
                Text("Home")
                Button(onClick= {
                    navController.navigate("Office") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Office로 이동")
                }
                Button(onClick= {
                    navController.navigate("Playground") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Playground로 이동")
                }
                Button(onClick= {
                    navController.navigate("login/kgb")
                }) {
                    Text("kgb로 이동")
                }
            }
        }
        composable("Office"){
            Column {
                Text("Office")
                Button(onClick= {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Home으로 이동")
                }
                Button(onClick= {
                    navController.navigate("Playground") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Playground로 이동")
                }
            }
        }
        composable("Playground"){
            Column {
                Text("Playground")
                Button(onClick= {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Home으로 이동")
                }
                Button(onClick= {
                    navController.navigate("Office") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Office로 이동")
                }
            }
        }
        composable("login/{userId}") {
            val userId = it.arguments?.get("userId")
            Text("userId: $userId")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeArchitectureTheme {
        naviEx()
    }
}