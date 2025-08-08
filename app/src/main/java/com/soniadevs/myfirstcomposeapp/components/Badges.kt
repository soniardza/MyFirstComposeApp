package com.soniadevs.myfirstcomposeapp.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.soniadevs.myfirstcomposeapp.R

@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(contentColor = Color.Red, containerColor = Color.Green) {
        Text("5")
    }
}

@Composable
fun MyBadgeBox(modifier: Modifier = Modifier) {
    BadgedBox(badge = { MyBadge() }) {
        Icon(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_info),
            contentDescription = ""
        )
    }
}
