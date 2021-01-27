package com.fjbg.circularreveal.ui.animation

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.core.*
import androidx.compose.ui.graphics.Color
import com.fjbg.circularreveal.ui.theme.purple700

val sizeState = FloatPropKey()
val colorState = ColorPropKey()
val alphaState = FloatPropKey()

enum class FabState { Idle, Exploded }

const val animationDuration = 2000

fun fabSizeTransitionDefinition(): TransitionDefinition<FabState> {
    return transitionDefinition {
        state(FabState.Idle) {
            this[sizeState] = 58f
            this[colorState] = purple700
            this[alphaState] = 1f
        }
        state(FabState.Exploded) {
            this[sizeState] = 4000f
            this[colorState] = Color.White
            this[alphaState] = 0f
        }

        transition(fromState = FabState.Idle, toState = FabState.Exploded) {
            sizeState using keyframes {
                durationMillis = animationDuration
                58f at 0
                30f at 150
                4000f at animationDuration
            }
            colorState using tween(
                durationMillis = animationDuration,
                easing = FastOutSlowInEasing
            )
        }
    }
}