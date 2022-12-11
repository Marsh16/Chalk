package com.uc.chalk.view

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uc.chalk.R
import com.uc.chalk.view.theme.*
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChalkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Navigation()

                }
            }
        }
    }
}
//@Composable
//fun MyContent(){
//
//    // Fetching the Local Context
//    val mContext = LocalContext.current
//
//    val intent = Intent(mContext,LoginActivity::class.java)
//    mContext.startActivity(intent)
//
//
//}
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }

        // Main Screen
        composable("main_screen") {
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
                        text = "Log In",
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
    }
}
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(3000L)
        navController.navigate("main_screen")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Blue1)) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.chalklogo),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}