package kgb.plum.composearchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kgb.plum.composearchitecture.ui.theme.ComposeArchitectureTheme

class CompositionLocalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

val LocalContentElevation = compositionLocalOf { 8.dp }
@Composable
fun Greeting() {
    CompositionLocalProvider(LocalContentElevation provides 20.dp ) {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = LocalContentElevation.current
        ) {
            Column(modifier = Modifier.padding(8.dp)){
                Text("안녕하세요. 김근범입니다~")
                CompositionLocalProvider(LocalContentAlpha provides 0.3f) {
                    Text("안녕하세요. 김근범입니다~")
                    Text("안녕하세요. 김근범입니다~", modifier = Modifier.alpha(LocalContentAlpha.current))

                    CompositionLocalProvider(LocalContentColor provides Color.Blue){
                        Text("안녕하세요. 김근범입니다~")
                        Text("${LocalContentAlpha.current}")
                    }
                }
                Text("안녕하세요. 김근범입니다~")
                Text("안녕하세요. 김근범입니다~")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArchitectureTheme {
        Greeting()
    }
}