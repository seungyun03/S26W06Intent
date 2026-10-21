package kr.ac.kumoh.ce.s20230010.s26w06intent

import android.R.attr.onClick
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

            ) {
            IntentYoutube()
            MyFavoritSongYoutube()

        }
    }
}
@Composable
fun IntentYoutube(modifier: Modifier = Modifier)
{
    val content = LocalContext.current
    Button(
        modifier = modifier.fillMaxWidth().padding(30.dp),
        onClick = {
            val url = Uri.parse("https://www.youtube.com/results?search_query=android+developers")
            val intent = Intent(Intent.ACTION_VIEW,url)
            content.startActivity(intent)
        }
    ) {

        Text("버튼", fontSize = 30.sp)
    }
}

@Composable
fun MyFavoritSongYoutube(modifier: Modifier = Modifier)
{
    val content = LocalContext.current
    Button(
        modifier = Modifier.fillMaxWidth().padding(30.dp),
        onClick = {
            val uri = Uri.parse("https://www.youtube.com/watch?v=jAhCOdrgMao&list=RDjAhCOdrgMao&index=1")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            content.startActivity(intent)
        }
    ) {
        Text("내가 좋아하는 공부음악_youtube", fontSize = 18.sp, lineHeight = 30.sp)
    }
}