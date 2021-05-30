package com.example.calculatorcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorcomposeapp.ui.theme.CalculatorComposeAppTheme
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : ComponentActivity() {

    private val operationCalc = mutableStateOf("")
    private val resultCalc = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Calculator()
                }
            }
        }
    }


    @Composable
    fun Calculator() {
        val operationField by operationCalc
        val resultField by resultCalc

        Column {
            Text(
                text = operationField,
                textAlign = TextAlign.End,
                fontSize = 42.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .padding(6.dp)

            )
            Text(
                text = resultField,
                textAlign = TextAlign.End,
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
                    .padding(0.dp,8.dp,10.dp,0.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))

            val numberButtonColor = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.dim_gray)
            )
            val actionButtonColor = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.steel_blue)
            )
            val equalButtonColor = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.goldenrod)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Button(
                        onClick = { setTextFields("7") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "7",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("8") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "8",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("9") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "9",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("/") },
                        colors = actionButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "/",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Button(
                        onClick = { setTextFields("4") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "4",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("5") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "5",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("6") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "6",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("*") },
                        colors = actionButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "*",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Button(
                        onClick = { setTextFields("1") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "1",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("2") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "2",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("3") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "3",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("-") },
                        colors = actionButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "-",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Button(
                        onClick = {
                            val str = operationCalc.value
                            if (str.isNotEmpty()) operationCalc.value =
                                str.substring(0, str.length - 1)
                            resultCalc.value = ""
                        },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.ic_backspace
                            ),
                            contentDescription = null
                        )
                    }
                    Button(
                        onClick = { setTextFields("0") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "0",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields(".") },
                        colors = numberButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = ".",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = { setTextFields("+") },
                        colors = actionButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "+",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(3.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Button(
                        onClick = {
                            operationCalc.value = ""
                            resultCalc.value = ""
                        },
                        colors = actionButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(3f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "AC",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }
                    Button(
                        onClick = {
                            try {
                                val ex = ExpressionBuilder(operationCalc.value).build()
                                val result = ex.evaluate()
                                val longRes = result.toLong()
                                if (result == longRes.toDouble()) resultCalc.value =
                                    longRes.toString()
                                else resultCalc.value = result.toString()
                            } catch (e: Exception) {
                                Log.d("Ошибка", "сообщение: ${e.message}")
                            }
                        },
                        colors = equalButtonColor,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f, true)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "=",
                            color = colorResource(id = R.color.white),
                            fontSize = 35.sp
                        )
                    }

                }
            }

        }

    }

    private fun setTextFields(str: String) {
        if (resultCalc.value != "") {
            operationCalc.value = resultCalc.value
            resultCalc.value = ""
        }
        operationCalc.value = "${operationCalc.value}$str"
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CalculatorComposeAppTheme {
            Calculator()
        }
    }
}