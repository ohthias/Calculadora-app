package com.learnwithjahangirjadi.calculatorjetpackcompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import delCharacter
import solveExpression

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {

    var expression by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = modifier
                .weight(1f)
                .padding(16.dp)
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = expression,
                style = TextStyle(
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.primary, // Updated to onBackground for text color
                    textAlign = TextAlign.End
                ),
                maxLines = 3
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = result,
                style = TextStyle(
                    fontSize = 48.sp,
                    color = MaterialTheme.colorScheme.primary, // Updated to onBackground for text color
                    textAlign = TextAlign.End
                )
            )
        }

        Column {
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(isFunction = true, text = "(", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "("
                    })
                CalculatorButton(isFunction = true, text = ")", modifier = modifier.weight(1f),
                    onClick = {
                        expression += ")"
                    })
                CalculatorButton(isFunction = true, text = "AC", modifier = modifier.weight(1f),
                    onClick = {
                        expression = ""
                        result = ""
                    })
                CalculatorButton(isFunction = true, text = "⌫", modifier = modifier.weight(1f),
                    onClick = {
                        expression = delCharacter(expression)
                    })
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(isFunction = true, text = "+/-", modifier = modifier.weight(1f),
                    onClick = {
                        expression = "(-$expression"
                    })
                CalculatorButton(isFunction = true, text = "√", modifier = modifier.weight(1f),
                    onClick = {
                        expression = "sqrt($expression)"
                    })
                CalculatorButton(isFunction = true, text = "%", modifier = modifier.weight(1f),
                    onClick = {
                        expression = "$expression/100*100"
                    })
                CalculatorButton(isFunction = true, text = "÷", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "/"
                    })
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(text = "7", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "7"
                    })
                CalculatorButton(text = "8", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "8"
                    })
                CalculatorButton(text = "9", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "9"
                    })
                CalculatorButton(
                    text = "×", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "*"
                    }, isFunction = true
                )
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(text = "4", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "4"
                    })
                CalculatorButton(text = "5", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "5"
                    })
                CalculatorButton(text = "6", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "6"
                    })
                CalculatorButton(
                    text = "+", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "+"
                    }, isFunction = true
                )
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(text = "1", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "1"
                    })
                CalculatorButton(text = "2", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "2"
                    })
                CalculatorButton(text = "3", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "3"
                    })
                CalculatorButton(
                    text = "-", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "-"
                    }, isFunction = true
                )
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(text = "0", modifier = modifier.weight(2f),
                    onClick = {
                        expression += "0"
                    })
                CalculatorButton(text = ".", modifier = modifier.weight(1f),
                    onClick = {
                        expression += "."
                    })
                CalculatorButton(
                    text = "=", modifier = modifier.weight(1f),
                    onClick = {
                        if (expression.isNotEmpty()) {
                            result = solveExpression(expression)
                        }
                    }, isFunction = true
                )
            }
        }
    }
}