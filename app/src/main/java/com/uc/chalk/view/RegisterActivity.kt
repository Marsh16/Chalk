package com.uc.chalk.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.composable
import com.uc.chalk.view.theme.ChalkTheme

class RegisterActivity  : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChalkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   a()

                }
            }
        }
    }
}
@Composable
fun a() {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEBF1FF))
            .padding(32.dp)) {
            Column() {
                Text(
                    text = "Chalk",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp,16.dp)
                )
                Text(
                    text = "Register",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp,16.dp))
                var text by remember { mutableStateOf("") }

                BasicTextField(
                    value = text,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { text = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (text.isEmpty()) {
                                Text("Your Username")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },
                )
                BasicTextField(
                    value = text,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { text = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (text.isEmpty()) {
                                Text("Your  Password")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                val mContext = LocalContext.current
                Button( onClick = {

                }) {
                    Text(text = "Log In")

                }
                Text(
                    text = "Don’t Have An Account? Register",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp,16.dp)
                )
            }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChalkTheme {
        a()
    }
}