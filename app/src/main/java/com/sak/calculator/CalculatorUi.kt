package com.sak.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Preview(showBackground = true)
@Composable
fun HomePage() {
    numbPad()
}

@Composable
fun numbPad(view: CalViewModel = viewModel()) {

    val state = view.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            Text(
                text = state.inputstate,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Button(
                    onClick = { view.cleardata() },
                    modifier = Modifier
                        .size(70.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "AC", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = { view.deletedata() },
                    modifier = Modifier
                        .size(70.dp)
                        .weight(1f),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "Del", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = { view.enterdata("%")},
                    modifier = Modifier
                        .size(70.dp)
                        .weight(1f),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "%", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = { view.enterdata("÷") },
                    modifier = Modifier
                        .size(70.dp)
                        .weight(1f),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(text = "÷", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Button(onClick = {
                    view.enterdata("7")
                }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "7", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("8") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "8", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("9") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "9", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("x") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "x", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Button(onClick = { view.enterdata("4")}, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "4", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("5") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "5", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("6") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "6", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {view.enterdata("-")}, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "-", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Button(onClick = { view.enterdata("1")}, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "1", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("2")}, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "2", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("3")}, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "3", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { view.enterdata("+") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "+", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Button(onClick = { view.enterdata("00") }, modifier = Modifier
                    .size(190.dp, 70.dp)
                    .weight(1f), shape = MaterialTheme.shapes.large) {
                    Text(text = "00", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = { view.enterdata("0") }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "0", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = { view.enterdata(".")}, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = ".", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = { view.calculate()

                                 }, modifier = Modifier
                    .weight(1f)
                    .size(70.dp), shape = MaterialTheme.shapes.large) {
                    Text(text = "=", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
