package com.fjbg.circularreveal.ui

import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.fjbg.circularreveal.ui.animation.FabState
import com.fjbg.circularreveal.ui.animation.colorState
import com.fjbg.circularreveal.ui.animation.fabSizeTransitionDefinition
import com.fjbg.circularreveal.ui.animation.sizeState

@Composable
fun CircularRevealApp(
    content: @Composable (PaddingValues) -> Unit,
) {

}

@Composable
fun explodingFloatingActionButton(action: () -> Unit) {
    val state = remember { mutableStateOf(FabState.Exploded) }
    val transition = transition(
        definition = fabSizeTransitionDefinition(),
        initState = FabState.Idle,
        toState = if (state.value == FabState.Idle) FabState.Exploded else FabState.Idle,
        onStateChangeFinished = { action.invoke() }
    )
    fab(fabState = state, transition = transition)
}

@Composable
fun fab(
    fabState: MutableState<FabState>,
    transition: TransitionState
) {
    FloatingActionButton(
        backgroundColor = transition[colorState],
        /*icon = {
            Icon(
                asset = Icons.Default.Add,
                tint = Color.White,
            )
        },*/
        modifier = Modifier.size(transition[sizeState].dp),
        onClick = { fabState.value = FabState.Idle }
    ) {}
}