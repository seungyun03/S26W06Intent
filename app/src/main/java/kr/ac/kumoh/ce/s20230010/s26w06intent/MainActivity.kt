package kr.ac.kumoh.ce.s20230010.s26w06intent
import android.content.Intent
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
import androidx.core.net.toUri
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
    val intentitems: List<Pair<String,String>> = listOf(
        "유튜브" to "https://www.youtube.com/results?search_query=android+developers",
        "인스타그램" to "https://www.instagram.com/blackpinkofficial/",
        "페이스북" to "https://www.facebook.com/bangtan.official",
        "우리집 좌표" to "geo:36.145014,128.393047?z=17",
        "우리집 주소" to "geo:0,0?q=국립금오공과대학교",
        "전화" to "tel:054-478-7114",
        "문자" to "sms:054-478-7114"
    )
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
         intentitems.forEach { item->
             IntentButton(Modifier,item)
         }
        }
    }
}
@Composable
fun IntentButton(modifier: Modifier,item: Pair<String, String>)
{
    val content = LocalContext.current
    val(text,link) = item
    Button(
        modifier = modifier.fillMaxWidth().padding(30.dp),
        onClick = {
            val url = link.toUri()
            val intent = Intent(Intent.ACTION_VIEW,url)
            content.startActivity(intent)
        }
    ) {
        Text(text, fontSize = 30.sp)
    }
}

