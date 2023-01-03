package com.uc.chalk.view.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.R
import com.uc.chalk.view.Screen
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel

class LoginActivity: ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChalkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    b()
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun b() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(32.dp)
    ){
        Column {
            Text(
                text = "Chalk",
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = "Log In",
                fontFamily = firaSans,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                modifier = Modifier.padding(0.dp,16.dp)
            )
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            val maxChar = 200
            var passwordVisibility by remember { mutableStateOf(false) }
            val passIcon = if (passwordVisibility)
                painterResource(id = R.drawable.design_ic_visibility)
            else
                painterResource(id = R.drawable.design_ic_visibility_off)

            Column(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)) {
                OutlinedTextField(
                    value = username,
                    onValueChange = {
                        if (it.length <= maxChar) {
                            username = it
                        } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp),
                    label = { Text(text = "Username") },
                    placeholder = { Text(text = "Enter your username") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
//                        trailingIcon = IconButton(onClick = { name = "" }) {
//                            Icon(
//                                painter = cancelIcon,
//                                contentDescription = "Cancel Icon"
//                            )
//                        },
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary,
                        cursorColor = MaterialTheme.colorScheme.primary
                    )
                )
                OutlinedTextField(
                    value = password,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp),
                    singleLine = true,
                    onValueChange = {
                        if (it.length >= 8) {
                            password = it
                        }
                    },
                    placeholder = { Text(text = "Enter your password") },
                    label = { Text(text = "Password")},
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(
                                painter = passIcon,
                                contentDescription = "Visibility Icon")
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )
            }
            val mContext = LocalContext.current
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp),
                onClick = {
                    val intent = Intent(mContext,Screen.Home.route::class.java)
                    intent.putExtra("username", username)
                    mContext.startActivity(intent)
            }) {
                Text(text = "Log In")
            }
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Don't Have An Account? ",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 12.sp
                )
                Text(
                    text = "Register",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {
                        val intent = Intent(mContext, RegisterActivity::class.java)
                        mContext.startActivity(intent)
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun bPreview() {
    b()
}