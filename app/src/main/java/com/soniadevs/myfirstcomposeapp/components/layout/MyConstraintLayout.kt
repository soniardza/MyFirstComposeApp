package com.soniadevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()

        Box(Modifier.size(150.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })
        Box(Modifier.size(150.dp).background(Color.Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })
        Box(Modifier.size(150.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxYellow.end)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(150.dp).background(Color.Magenta).constrainAs(boxMagenta){
            end.linkTo(boxYellow.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(150.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })
    }
}

@Composable
fun MyBasicConstraintLayoutChallenge(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxBlack, boxMagenta, boxGreen, boxYellow, boxGray, boxRed, boxBlue, boxCyan, boxDarkGray) = createRefs()

        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxMagenta.top)
            end.linkTo(boxMagenta.end)
        })
        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack){
            start.linkTo(boxCyan.end)
            end.linkTo(boxDarkGray.start)
            bottom.linkTo(boxCyan.bottom)
            top.linkTo(boxCyan.top)
        })
        Box(Modifier.size(175.dp).background(Color.DarkGray).constrainAs(boxDarkGray){
            bottom.linkTo(boxGreen.top)
            start.linkTo(boxGreen.start)
        })
        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta){
            end.linkTo(boxYellow.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxYellow.end)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(boxYellow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray){
            end.linkTo(boxYellow.start)
            top.linkTo(boxYellow.bottom)
        })
        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })
    }
}
