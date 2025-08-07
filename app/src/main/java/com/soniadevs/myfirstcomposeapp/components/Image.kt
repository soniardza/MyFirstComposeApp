package com.soniadevs.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.soniadevs.myfirstcomposeapp.R

@Composable
fun MyImage(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.avatar_profile),
            contentDescription = "Avatar image profile",
            modifier = Modifier
                .size(100.dp)
                .clip(
                    RoundedCornerShape(
                        topEnd = 70.dp,
                        bottomStart = 70.dp
                    )
                ),
            contentScale = ContentScale.FillHeight
        )
        Image(
            painter = painterResource(R.drawable.avatar_profile),
            contentDescription = "Avatar image profile",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(50))
                .border(
                    width = 5.dp,
                    color = Color.Blue,
                    shape = CircleShape,
                ),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(R.drawable.avatar_profile),
            contentDescription = "Avatar image profile",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(50))
                .border(
                    width = 5.dp,
                    shape = CircleShape,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                            Color.Yellow
                        )
                    )
                ),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    Column(modifier = modifier) {
        AsyncImage(
            model = "https://avatars.githubusercontent.com/u/16361358",
            contentDescription = "Image from Network",
            modifier = Modifier.size(150.dp),
            onError = {
                Log.i("Image", "Ha oucrrido un error ${it.result.throwable.message}")
            }
        )
    }
}

@Composable
fun MyIcon(modifier: Modifier) {
    Column(modifier = modifier) {
        Icon(
            painter = painterResource(R.drawable.ic_personita),
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            tint = Color.Blue
        )
    }
}
