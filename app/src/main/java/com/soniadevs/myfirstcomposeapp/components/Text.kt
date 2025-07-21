package com.soniadevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text("Texto sin atributos")
        Text("Texto rojo", color = Color.Red)
        Text("Texto con 25 sp", fontSize = 25.sp)
        Text("Texto en italic", fontStyle = FontStyle.Italic)
        Text(
            text = "Texto con FontWeight Italic y 25.sp",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text("LetterSpacing 4.sp", letterSpacing = 4.sp)
        Text(
            text = "TextDecoration Underline",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue
        )
        Text(
            text = "TextDecoration combinado",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            text = "Align center with max lines in 1 and overFlow in Ellipsis ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
