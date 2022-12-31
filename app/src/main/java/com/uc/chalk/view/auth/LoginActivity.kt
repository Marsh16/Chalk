package com.uc.chalk.view.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun b() {
    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state = rememberScrollState(), true, null, false)
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
            Column(modifier = Modifier.padding(0.dp,8.dp)) {
                BasicTextField(
                    value = username,
                    modifier = Modifier
                        .padding(0.dp,16.dp),
                    singleLine = true,
                    onValueChange = {username = it},
                    decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .border(
                                    2.dp,
                                    MaterialTheme.colorScheme.onBackground,
                                    RoundedCornerShape(4.dp)
                                )
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            if (username.isEmpty()) {
                                Text(
                                    text = "Your Username",
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 14.sp
                                )
                            }
                            innerTextField()
                        }
                    }
                )
                BasicTextField(
                    value = password,
                    modifier = Modifier
                        .padding(0.dp,8.dp,0.dp,16.dp),
                    singleLine = true,
                    onValueChange = {password = it},
                    decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .border(
                                    2.dp,
                                    MaterialTheme.colorScheme.onBackground,
                                    RoundedCornerShape(4.dp)
                                )
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            if (password.isEmpty()) {
                                Text(text = "Your Password")
                            }
                            innerTextField()
                        }
                    }
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