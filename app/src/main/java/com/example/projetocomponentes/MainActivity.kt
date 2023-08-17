package com.example.projetocomponentes

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projetocomponentes.ui.theme.ProjetoComponentesTheme
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Column

private val Icons.Rounded.Link: Any
    get() {
        TODO("Not yet implemented")
    }
private val Any.isVisible: Boolean
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun App(){
    ProjetoComponentesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
             verticalArrangement = Arrangement.SpaceEvenly,
             horizontalAlignment = Alignment.CenterHorizontally
             ){
                MenuTopBar()
                Greeting(name = "Android")
            }
            }
            Greeting("Android")
        }
    }


@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview(){
    App()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuTopBar(){
    /*Para o scaffold precisa de uma biblioteca importada(na linha 66)*/
    Scaffold (
        topBar={
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue
                ),
                title = {
                    Column {
                        Text(text = "JetPack", color = Color.White)
                    }
                },
                navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.ArrowBack, tint = Color.White, contentDescription = "Seta voltando :)")
                        }
                },
                actions = {
                    Icon(imageVector = Icons.Filled.MoreVert, tint = Color.White, contentDescription = "Mais opções")
                }
            )

        }
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)){

        }
    }
}

@Preview(showBackground = true, )
@Composable
fun ModalBottomSheetWithVerticalActionsPreview(){
    ModalBottomSheetWithVerticalActions()
}

@Preview(showBackground = true, )
@Composable
fun MenuTopBarPreview(){
    MenuTopBar()
}

@Composable
fun ModalBottomSheetWithVerticalActions() {
    val state = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        state.show()
    }

    if (state.isVisible) {
        ModalBottomSheet(
            windowInsets = WindowInsets(0.dp),
            onDismissRequest = {
                scope.launch {
                    state.hide()
                }
            }) {
            val items = listOf(
                Icons.Rounded.Share to "Share",
                Icons.Rounded.Link to "Get Link",
                Icons.Rounded.Edit to "Edit name",
                Icons.Rounded.Delete to "Delete items",
            )
            Column(Modifier.navigationBarsPadding()) {
                items.forEach { item ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(32.dp),
                        modifier = Modifier
                            .clickable { /* TODO */ }
                            .clip(MaterialTheme.shapes.medium)
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp, vertical = 18.dp),
                    ) {
                        Icon(item.first, null)
                        Text(item.second)
                    }
                }
            }
        }
    }
}

private fun Any.hide() {
    TODO("Not yet implemented")
}

private fun Any.show() {
    TODO("Not yet implemented")
}

@Composable
fun ModalBottomSheet(windowInsets: Any, onDismissRequest: () -> Unit, content: () -> Unit) {

}

fun rememberModalBottomSheetState(skipPartiallyExpanded: Boolean): Any {
    TODO("Not yet implemented")
}


@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun GreetingPreview() {
    ProjetoComponentesTheme {
        Greeting("Android")
    }
}