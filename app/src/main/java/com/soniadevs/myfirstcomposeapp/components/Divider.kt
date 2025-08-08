package com.soniadevs.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Parte de arriba")
        HorizontalDivider(thickness = 3.dp, color = Color.Cyan)
        Text("Parte de abajo")

        Row(modifier = Modifier.height(100.dp)) {
            Text("Izquierda")
            VerticalDivider(thickness = 4.dp, color = Color.Cyan)
            Text("Derecha")
        }
    }
}
