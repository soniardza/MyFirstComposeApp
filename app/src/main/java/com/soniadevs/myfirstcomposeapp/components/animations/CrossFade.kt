package com.soniadevs.myfirstcomposeapp.components.animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.soniadevs.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun MyCrossFade() {
    var currentState by remember { mutableStateOf("Home") }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Home",
                modifier = Modifier
                    .weight(1f)
                    .clickable { currentState = "Home" },
                textAlign = TextAlign.Center
            )
            Text(
                "Detail",
                modifier = Modifier
                    .weight(1f)
                    .clickable { currentState = "Detail" },
                textAlign = TextAlign.Center
            )
            Text(
                "Login",
                modifier = Modifier
                    .weight(1f)
                    .clickable { currentState = "Login" },
                textAlign = TextAlign.Center
            )
        }

        Crossfade(targetState = currentState) { screen ->
            when (screen) {
                "Home" -> HomeScreen(navigateBack = {}, navigateToDetail = { _ -> })
                "Detail" -> DetailScreen(id = "", navigateToSettings = {})
                "Login" -> LoginScreen { }
            }
        }
    }
}
