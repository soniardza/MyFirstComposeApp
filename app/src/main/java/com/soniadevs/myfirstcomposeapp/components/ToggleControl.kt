package com.soniadevs.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.soniadevs.myfirstcomposeapp.R
import com.soniadevs.myfirstcomposeapp.components.state.CheckBoxState

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_personita),
                    contentDescription = null
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                // Bolita
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                disabledUncheckedThumbColor = Color.Cyan,
                // Icono
                checkedIconColor = Color.Green,
                uncheckedIconColor = Color.Cyan,
                disabledUncheckedIconColor = Color.Red,
                disabledCheckedIconColor = Color.Red,
                // Borde
                checkedBorderColor = Color.Magenta,
                uncheckedBorderColor = Color.Magenta,
                disabledCheckedBorderColor = Color.Magenta,
                disabledUncheckedBorderColor = Color.Magenta,
                // Track
                checkedTrackColor = Color.White,
                uncheckedTrackColor = Color.Black,
                disabledCheckedTrackColor = Color.White,
                disabledUncheckedTrackColor = Color.Black
            )
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(true) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }
        ) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    checkmarkColor = Color.Blue,
                    uncheckedColor = Color.Blue,
                    disabledCheckedColor = Color.Yellow,
                    disabledUncheckedColor = Color.Yellow,
                )
            )
            Spacer(Modifier.width(12.dp))
            Text("Acepto los términos y condiciones")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("terms", "Aceptar los términos y condiciones"),
                CheckBoxState("newsletter", "Recibir newsletter", true),
                CheckBoxState("updates", "Recibir las actualizaciones"),
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked, label = "")
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckChange(checkBoxState) }
    ) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckChange(checkBoxState) },
            enabled = true,
        )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var childOne by remember { mutableStateOf(false) }
    var childTwo by remember { mutableStateOf(false) }

    LaunchedEffect(childOne, childTwo) {
        parentState = when {
            childOne && childTwo -> ToggleableState.On
            !childOne && !childTwo -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                childOne = newState
                childTwo = childOne
            })
            Text("Seleccionar todo")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(childOne, onCheckedChange = { childOne = it })
            Text("Ejemplo 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(childTwo, onCheckedChange = { childTwo = it })
            Text("Ejemplo 2")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = state,
            onClick = { state = true },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Magenta
            )
        )
        Text("Ejemplo 1")
    }
}


@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        RadioButtonComponent(name = "Sonia", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Irene", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Pedro", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Les", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Eli", selectedName = selectedName) { selectedName = it }
    }
}

@Composable
fun RadioButtonComponent(
    name: String,
    selectedName: String,
    onItemSelected: (String) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = name == selectedName,
            onClick = { onItemSelected(name)}
        )
        Text(
            name,
            modifier = Modifier.clickable { onItemSelected(name) }
        )
    }
}
