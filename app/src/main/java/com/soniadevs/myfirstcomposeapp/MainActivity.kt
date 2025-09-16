package com.soniadevs.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.soniadevs.myfirstcomposeapp.components.MyCustomDialog
import com.soniadevs.myfirstcomposeapp.components.MyFAB
import com.soniadevs.myfirstcomposeapp.components.MyHorizontalGridList
import com.soniadevs.myfirstcomposeapp.components.MyModalDrawer
import com.soniadevs.myfirstcomposeapp.components.MyTopAppBar
import com.soniadevs.myfirstcomposeapp.components.animations.FullAnimateAsState
import com.soniadevs.myfirstcomposeapp.components.animations.MyAnimatedContent
import com.soniadevs.myfirstcomposeapp.components.animations.MyAnimatedVisibility
import com.soniadevs.myfirstcomposeapp.components.animations.MyContentSize
import com.soniadevs.myfirstcomposeapp.components.animations.MyCrossFade
import com.soniadevs.myfirstcomposeapp.components.animations.MyInfiniteTransition
import com.soniadevs.myfirstcomposeapp.components.model.PokemonCombat
import com.soniadevs.myfirstcomposeapp.components.navigation.NavigationWrapper
import com.soniadevs.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackBarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat(pokemonA = "Pikachu", pokemonB = "Gengar")

                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = { showDialog = false },
                    onDismissDialog = { showDialog = false }
                )

                MyInfiniteTransition()
                // NavigationWrapper()
                /* MyModalDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            MyTopAppBar {
                                scope.launch { drawerState.open() }
                            }
                        },
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        floatingActionButton = { MyFAB { showDialog = true } },
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = { MyNavigationBar() }
                    ) { innerPadding ->
                        Box(
                           modifier = Modifier
                               .fillMaxSize()
                               .padding(innerPadding)
                               .background(Color.Cyan),
                           contentAlignment = Alignment.Center
                       ) {
                            Text("Esta es mi screen",
                               modifier = Modifier.clickable {
                                   scope.launch {
                                       val result = snackBarHostState.showSnackbar(
                                           message = "Ejemplo",
                                           actionLabel = "Deshacer"
                                       )

                                       if (result == SnackbarResult.ActionPerformed) {
                                           // pulso deshacer
                                       } else {
                                           // no hizo nada
                                       }
                                   }
                               })
                            // MyInteractionSourceExample()
                            // MyLaunchedEffect {}
                            // MyDerivedStateOfExample()
                            // MyHorizontalGridList()
                        }
                    }
                } */
            }
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}
