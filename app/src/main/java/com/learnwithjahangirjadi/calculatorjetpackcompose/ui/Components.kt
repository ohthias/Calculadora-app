package com.learnwithjahangirjadi.calculatorjetpackcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier, text: String = "0",
    isFunction: Boolean = false, onClick: (String) -> Unit = {}
) {
    Button(
        modifier = modifier
            .size(72.dp)
            .clip(CircleShape)
            .padding(4.dp),
        onClick = { onClick(text) },
        colors = ButtonDefaults.buttonColors(
            containerColor = when {
                isFunction && text == "=" || text == "AC" -> MaterialTheme.colorScheme.secondary
                isFunction -> MaterialTheme.colorScheme.error
                else -> MaterialTheme.colorScheme.tertiary
            }
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 24.sp,
                color = when {
                    isFunction && text != "=" && text != "AC" -> MaterialTheme.colorScheme.background
                    isFunction -> MaterialTheme.colorScheme.onError
                    else -> MaterialTheme.colorScheme.onSurface
                }
            )
        )
    }
}

@Preview
@Composable
fun CalculatorButtonPrev() {
    CalculatorButton()
}
