package com.fjbg.circularreveal.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.fjbg.circularreveal.navigation.Destinations.Home
import com.fjbg.circularreveal.navigation.Destinations.SecondView

object Destinations {
    const val Home = "home"
    const val SecondView = "secondView"
}

class Action(navController: NavHostController) {
    val home: () -> Unit = { navController.navigate(Home) }
    val secondView: () -> Unit = { navController.navigate(SecondView) }
}