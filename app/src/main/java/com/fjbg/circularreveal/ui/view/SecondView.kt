package com.fjbg.circularreveal.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun secondView() {
    commonView(
        action = null,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(36.dp)
            ) {
                Text(
                    fontFamily = FontFamily.Serif,
                    text = "this is the Second view",
                    fontSize = 32.sp
                )
            }
        }
    )
}