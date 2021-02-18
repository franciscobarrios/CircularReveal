package com.fjbg.circularreveal.ui.view

import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fjbg.circularreveal.ui.animation.FabState
import com.fjbg.circularreveal.ui.animation.colorState
import com.fjbg.circularreveal.ui.animation.fabSizeTransitionDefinition
import com.fjbg.circularreveal.ui.animation.sizeState

@Composable
fun commonView(
    action: (() -> Unit)?,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {},
        bodyContent = content,
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape
            ) {

            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            action?.let { explodingFloatingActionButton(action = it) }
        }
    )
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
    fab(state = state, transition = transition)
}

@Composable
fun fab(
    state: MutableState<FabState>,
    transition: TransitionState
) {
    FloatingActionButton(
        backgroundColor = transition[colorState],
        modifier = Modifier.size(transition[sizeState].dp),
        onClick = { state.value = FabState.Idle },
        icon = {
            Icon(
                asset = Icons.Default.Add,
                tint = Color.White,
            )
        },
    )
}