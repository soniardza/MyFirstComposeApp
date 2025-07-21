package com.soniadevs.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("Sonia") }
    var value by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        UserTextField(user) { user = it }
        TextFieldWithPlaceHolder(value) { value = it }
        EmailTextField(email) { email = it }
        MyPasswordField(password) { password = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(value) { value = it }
    }
}

@Composable
fun UserTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = user.isEmpty())
}

@Composable
fun TextFieldWithPlaceHolder(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Box(
                Modifier
                    .size(40.dp)
                    .background(Color.Red)
            )
        }
    )
}

@Composable
fun EmailTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text("Introduce tu email") }
    )
}

@Composable
fun MyPasswordField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(true) }

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            Text(text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
    )
}
