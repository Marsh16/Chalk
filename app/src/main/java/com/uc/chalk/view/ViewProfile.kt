package com.uc.chalk.view

//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import com.uc.chalk.view.auth.checker
//import com.uc.chalk.view.auth.postUser
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.uc.chalk.helper.Const
import com.uc.chalk.view.auth.LoginActivity
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class ViewProfile() : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            ChalkTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//Log.e("masuk ke edit", "edita  a ")
                    var mContext = LocalContext.current
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = rememberScrollState(), true, null, false)
                        .background(MaterialTheme.colorScheme.background)
                        .padding(32.dp),

                    ) {
                        Column{

                            Text(
                                text = "Profile",
                                fontFamily = firaSans,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                                modifier = Modifier.padding(0.dp,16.dp))
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally) {

                                Text(
                                    text = Const.username,
                                    fontFamily = firaSans,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 30.sp,
                                       )
                                Text(
                                    text = "online",
//                                    color= Color.Green,
                                    fontSize = 30.sp,
                                    fontFamily = firaSans,
                                    fontWeight = FontWeight.Light,
                                    color = Color.Green,
                                    //   fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                                    )
                            }

                            val mContext = LocalContext.current
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(0.dp, 16.dp, 0.dp, 8.dp),
                                onClick = {
//                                    mainViewModel.patchUser(
//                                        Const.user_id,name1,
//                                        username1,
//                                        email12,
//                                        phone_number1,
//                                        dateofbirth1,
//                                        password1,
//                                    )
                                    val intent = Intent(mContext, ProfileScreen::class.java)
                                    //   intent.putExtra("username", response.username)
                                    mContext.startActivity(intent)
//                    postDataUsingRetrofit(
//                        mContext,name,name,email,phone_number,dateofbirth,password,response
//                    )
                                  //  Toast.makeText(mContext, "Profile Edited", Toast.LENGTH_SHORT).show()
                                }) {
                                Text(text = "Edit")
                            }
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(0.dp, 16.dp, 0.dp, 8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.White, containerColor = Color(0xFFEC4237)
                                ),
                                onClick = {
//                                    mainViewModel.patchUser(
//                                        Const.user_id,name1,
//                                        username1,
//                                        email12,
//                                        phone_number1,
//                                        dateofbirth1,
//                                        password1,
//                                    )
                                    val intent = Intent(mContext, LoginActivity::class.java)
                                    //   intent.putExtra("username", response.username)
                                    mContext.startActivity(intent)
//                    postDataUsingRetrofit(
//                        mContext,name,name,email,phone_number,dateofbirth,password,response
//                    )
                                    Toast.makeText(mContext, "Log Out", Toast.LENGTH_SHORT).show()
                                }) {
                                Text(text = "Log Out")
                            }


                        }


                    }

                }
            }
        }

    }
}

