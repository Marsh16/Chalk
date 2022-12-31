package com.uc.chalk.view

import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uc.chalk.R
import com.uc.chalk.view.auth.RegisterActivity
import com.uc.chalk.view.theme.ui.Blue10
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

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


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ChalkTheme {
//        Navigation()
        MainScreen()
    }
}

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
                .verticalScroll(state = rememberScrollState(), true, null, false)
                .background(Color(0xFFEBF1FF))
                .padding(32.dp)) {
                Column {
                    Text(
                        text = "Chalk",
                        fontFamily = firaSans,
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
                                    .background(Color.LightGray, RoundedCornerShape(4.dp))
                                    .padding(16.dp)
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
                    Column(
                        modifier = Modifier
                        .padding(0.dp, 16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Button( modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 16.dp),
                            onClick = {
                                val intent = Intent(mContext, RegisterActivity::class. java)
//                            intent.putExtra( name: "kelas", value: 8)
                                mContext.startActivity(intent)
                            }) {
                            Text(text = "Log In")
                        }
                    }

                    Row (
                        modifier = Modifier.padding(16.dp)
                            ){
                        Text(
                            text = "Don’t Have An Account?",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 12.sp,

                        )
                        Text(text = "Register",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold,
                            color = Blue10,
                            fontSize = 12.sp,
                        )
                    }

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
            .background(Blue10)) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.chalklogo),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}

