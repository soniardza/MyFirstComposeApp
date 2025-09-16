package com.soniadevs.myfirstcomposeapp.components.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FullAnimateAsState() {
    var isSelected by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) Color(0xFFE57373) else Color(0xFFFFF176)
    )
    val animatedSize by animateDpAsState(
        targetValue = if (isSelected) 300.dp else 150.dp
    )

    val animatedOffSize by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 100f) else Offset(0f, 0f)
    )

    val animatedFloat by animateFloatAsState(
        targetValue = if (isSelected) 0.1f else 1f
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(32.dp))
        Button(onClick = { isSelected = !isSelected }) {
            Text("Seleccionar")
        }
        Text("Float: %.2f".format(animatedFloat))
        Spacer(Modifier.height(32.dp))

        Box(
            Modifier
                .offset(animatedOffSize.x.dp, animatedOffSize.y.dp) // es importante ponerlo al inicio
                .size(animatedSize)
                .background(animatedColor)
        )
    }
}
