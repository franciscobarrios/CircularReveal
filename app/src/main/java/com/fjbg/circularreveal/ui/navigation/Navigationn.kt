package com.fjbg.circularreveal.ui.navigation

import androidx.navigation.NavHostController

object Destinations {
    const val mainView = "mainView"
    const val secondView = "secondView"
}

class Action(navController: NavHostController) {
    val mainView: () -> Unit = { navController.navigate(mainView)}
    val secondView: () -> Unit = { navController.navigate(secondView) }
}