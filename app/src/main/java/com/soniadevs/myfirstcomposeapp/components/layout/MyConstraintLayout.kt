package com.soniadevs.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()

        Box(Modifier.size(150.dp).background(Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })
        Box(Modifier.size(150.dp).background(Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })
        Box(Modifier.size(150.dp).background(Green).constrainAs(boxGreen){
            start.linkTo(boxYellow.end)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(150.dp).background(Magenta).constrainAs(boxMagenta){
            end.linkTo(boxYellow.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(150.dp).background(Yellow).constrainAs(boxYellow){
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

        Box(Modifier.size(175.dp).background(Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxMagenta.top)
            end.linkTo(boxMagenta.end)
        })
        Box(Modifier.size(75.dp).background(Black).constrainAs(boxBlack){
            start.linkTo(boxCyan.end)
            end.linkTo(boxDarkGray.start)
            bottom.linkTo(boxCyan.bottom)
            top.linkTo(boxCyan.top)
        })
        Box(Modifier.size(175.dp).background(DarkGray).constrainAs(boxDarkGray){
            bottom.linkTo(boxGreen.top)
            start.linkTo(boxGreen.start)
        })
        Box(Modifier.size(75.dp).background(Magenta).constrainAs(boxMagenta){
            end.linkTo(boxYellow.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Green).constrainAs(boxGreen){
            start.linkTo(boxYellow.end)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Yellow).constrainAs(boxYellow){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(175.dp).background(Blue).constrainAs(boxBlue){
            top.linkTo(boxYellow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(Modifier.size(75.dp).background(Gray).constrainAs(boxGray){
            end.linkTo(boxYellow.start)
            top.linkTo(boxYellow.bottom)
        })
        Box(Modifier.size(75.dp).background(Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })
    }
}

@Composable
fun ConstraintExampleGuide(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)

        Box(
            Modifier
                .size(150.dp)
                .background(Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                }
        )
    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(Modifier.size(65.dp).background(Red).constrainAs(boxRed) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Box(Modifier.size(200.dp).background(Yellow).constrainAs(boxYellow) {
            top.linkTo(boxRed.bottom, margin = 40.dp)
            start.linkTo(parent.start, margin = 32.dp)
        })
        Box(Modifier.size(70.dp).background(Cyan).constrainAs(boxCyan) {
            start.linkTo(barrier)
        })
    }
}

@Composable
fun ConstraintChain(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()

        Box(Modifier.size(100.dp).background(Red).constrainAs(boxRed) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(100.dp).background(Yellow).constrainAs(boxYellow) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxRed.bottom)
            bottom.linkTo(boxCyan.top)
        })
        Box(Modifier.size(100.dp).background(Cyan).constrainAs(boxCyan) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxYellow.bottom)
            bottom.linkTo(parent.bottom)
        })
        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Packed)
//        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Spread)
//        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.SpreadInside)
    }
}
