package kr.ac.kumoh.ce.s20230010.s26w06intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20230010.s26w06intent.ui.theme.S26W06IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S26W06IntentTheme {
                MainScreen()
                }
            }
        }
    }

@Composable
fun MainScreen()
{
    Scaffold(modifier = Modifier) {
        innerpadding->
        Column(modifier = Modifier
            .padding(innerpadding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            )
        {
            IntentButton(Modifier,"강의 유튜브","https://www.youtube.com/results?search_query=android+developers")
            IntentButton(Modifier,"내 노래 유튜브","https://www.youtube.com/watch?v=jAhCOdrgMao&list=RDjAhCOdrgMao&index=1")
        }
    }
}
@Composable
fun IntentButton(modifier: Modifier,text: String,uri: String)
{
    val content = LocalContext.current
    Button(
        modifier = modifier.fillMaxWidth().padding(30.dp),
        onClick = {
            val url = Uri.parse(uri)
            val intent = Intent(Intent.ACTION_VIEW,url)
            content.startActivity(intent)
        }
    ) {
        Text(text, fontSize = 30.sp)
    }
}

