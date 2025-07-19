package com.soniadevs.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyBasicState(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }
    Column {
        Text("Púlsame: $number", modifier.clickable { number += 1 })
        Text("Púlsame: $number", modifier.clickable { number += 1 })
    }
}

@Composable
fun MyStateHoisting(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        StateHoistingExample1(number) { number +=1 }
        StateHoistingExample2(number = number, onCLick = { number += 1 })
    }
}

@Composable
fun StateHoistingExample1(number: Int, onCLick: () -> Unit) {
    Text("Púlsame: $number", Modifier.clickable { onCLick() })
}

@Composable
fun StateHoistingExample2(number: Int, onCLick: () -> Unit) {
    Text("Púlsame: $number", Modifier.clickable { onCLick() })
}
