package com.uc.chalk.view.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.material.R
import com.uc.chalk.helper.Const
import com.uc.chalk.model.Token
import com.uc.chalk.view.HomeScreen
import com.uc.chalk.view.MainActivity
//import com.uc.chalk.view.MainScreen
import com.uc.chalk.view.Screen
import com.uc.chalk.view.theme.ui.Blue10
import com.uc.chalk.view.theme.ui.Blue40
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class LoginActivity: ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChalkTheme {
                mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash_screen"
                    ) {
                        composable("splash_screen") {
                            SplashScreen(navController = navController)
                        }
                        // Main Screen
                        composable("main_screen") {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background)
                                    .padding(32.dp)
                            ) {
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
                                        modifier = Modifier.padding(0.dp, 16.dp)
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
                                                }
                                            },
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
                                            label = { Text(text = "Password") },
                                            trailingIcon = {
                                                IconButton(onClick = {
                                                    passwordVisibility = !passwordVisibility
                                                }) {
                                                    Icon(
                                                        painter = passIcon,
                                                        contentDescription = "Visibility Icon"
                                                    )
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
                                            var mainViewModel =
                                                ViewModelProvider(this@LoginActivity).get(
                                                    MainViewModel::class.java
                                                )

//                        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
                                            // mainViewModel.postLogin(username,password)
                                           // mainViewModel.token.observe(this@LoginActivity, Observer { response ->
                                                postLogin(
                                                    this@LoginActivity,
                                                    this@LoginActivity,
                                                    mContext,
                                                    username,
                                                    password,

                                                )
                                         //   })

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
                                                val intent =
                                                    Intent(mContext, RegisterActivity::class.java)
                                                mContext.startActivity(intent)
                                            }
                                        )
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }
                            }
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Blue40)
        ) {
            // Change the logo
            Image(
                painter = painterResource(id = com.uc.chalk.R.drawable.chalklogo),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value)
            )
        }
    }
}


    private fun postLogin(
        owner: LifecycleOwner,
        th: ViewModelStoreOwner,
        ctx: Context,
        username: String,
        password: String,

    ) {
        var mainViewModel = ViewModelProvider(th).get(MainViewModel::class.java)
//                        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (username == "") {
            Toast.makeText(
                ctx,
                "username is empty",
                Toast.LENGTH_SHORT
            ).show()
        } else if (password == "") {
            Toast.makeText(
                ctx,
                "password is empty",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            mainViewModel.getLogin(
                username,
                password,
            )

            // mainViewModel.cek.observe(th, Observer { response ->
//                                           marsha123marsha123
//

            Log.e("cek token activity", Const.userfail)
            if ("Internal Server Error" in Const.userfail) {
                Toast.makeText(
                    ctx,
                    "Username/password wrong",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

 mainViewModel.token.observe(owner, Observer { response ->

                Log.e("isi token", response.token )
     Log.e("isi username", response.username)
//                    Log.e("token",Const.token)
                 val intent = Intent(ctx, MainActivity::class.java)
        intent.putExtra("username", response.username)
                   ctx.startActivity(intent)
                    mainViewModel.getUserbyusername(response.username)

mainViewModel.getUser(Const.user_id,response.token)

               })
            }

        }
    }




