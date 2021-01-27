package com.fjbg.circularreveal.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.circularreveal.navigation.Action
import com.fjbg.circularreveal.navigation.Destinations.Home
import com.fjbg.circularreveal.navigation.Destinations.SecondView
import com.fjbg.circularreveal.ui.theme.CircularRevealTheme
import com.fjbg.circularreveal.ui.view.home
import com.fjbg.circularreveal.ui.view.secondView

@Composable
fun CircularRevealApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    CircularRevealTheme {
        NavHost(
            navController = navController,
            startDestination = Home
        ) {
            composable(Home) {
                home(actions.secondView)
            }
            composable(SecondView) {
                secondView()
            }
        }
    }
}