package com.asimodabas.canvasapimedium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.asimodabas.canvasapimedium.ui.theme.CanvasApiMediumTheme
import com.asimodabas.canvasapimedium.ui.theme.Purple200
import com.asimodabas.canvasapimedium.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasApiMediumTheme {
                ComponentIcon()
            }
        }
    }

    @Composable
    fun ComponentIcon(mySize: Dp = 100.dp) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            val canvasSizePx = with(LocalDensity.current) {
                mySize.toPx()
            }
            val infiniteScale = rememberInfiniteTransition()
            val animatedDotScale by infiniteScale.animateFloat(
                initialValue = 20f,
                targetValue = canvasSizePx / 2,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,
                        easing = FastOutLinearInEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Canvas(
                modifier = Modifier
                    .size(mySize)
            ) {
                rotate(degrees = 20f) {
                    translate(top = size.width / 3f) {
                        drawRect(
                            brush = Brush.linearGradient(
                                colors = listOf(Color.Black, Color.Red)
                            ),
                            size = size
                        )
                    }
                    drawCircle(
                        color = Color.White,
                        center = Offset(x = size.width / 2f, y = size.height / 2f),
                        radius = animatedDotScale
                    )
                }
            }
        }
    }

    @Composable
    fun Canvas(modifier: Modifier, onDraw: DrawScope.() -> Unit) =
        Spacer(modifier.drawBehind(onDraw))


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CanvasApiMediumTheme {
            ComponentIcon()
        }
    }
}