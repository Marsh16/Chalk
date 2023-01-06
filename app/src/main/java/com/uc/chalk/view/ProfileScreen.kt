package com.uc.chalk.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import com.google.android.material.R
import com.uc.chalk.helper.Const
import com.uc.chalk.helper.DATE_LENGTH
import com.uc.chalk.model.User
import com.uc.chalk.view.auth.LoginActivity
//import com.uc.chalk.view.auth.checker
//import com.uc.chalk.view.auth.postUser
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class ProfileScreen() : ComponentActivity() {
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
                            .padding(32.dp)) {
                            Column {
                                Button(

                                    onClick = {

                                        val intent = Intent(mContext, MainActivity::class.java)
                                        //   intent.putExtra("username", response.username)
                                        mContext.startActivity(intent)
//                    postDataUsingRetrofit(
//                        mContext,name,name,email,phone_number,dateofbirth,password,response
//                    )
                                        // Toast.makeText(mContext, "Profile Edited", Toast.LENGTH_SHORT).show()
                                    }) {
                                    Text(text = "Back")
                                }
                                Text(
                                    text = "Chalk",
                                    fontFamily = firaSans,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 24.sp,
                                    fontStyle = FontStyle.Italic
                                )

                                Text(
                                    text = "Edit Profile",
                                    fontFamily = firaSans,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                                    modifier = Modifier.padding(0.dp,16.dp))
                                var name1 by rememberSaveable { mutableStateOf("") }
                                var username1 by rememberSaveable { mutableStateOf("") }
                                var email12 by rememberSaveable { mutableStateOf("") }
                                var phone_number1 by rememberSaveable { mutableStateOf("") }
                                var dateofbirth1 by rememberSaveable { mutableStateOf("") }
                                var password1 by rememberSaveable { mutableStateOf("") }

                                val maxChar = 200
                                val minPass = 8
                                Column(modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)) {
                                    OutlinedTextField(
                                        value = name1,
                                        onValueChange = {
//                                            if (it.length <= maxChar) {
                                                name1 = it
//                                            }
                                        },
                                        label = { Text(text = "Name") },
                                        placeholder = { Text(text = "Enter your name") },
//                        trailingIcon = IconButton(onClick = { name }) {
//                            Icon(painter = cancelIcon, contentDescription = "Cancel Icon")
//                        },
                                        singleLine = true,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 16.dp),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Next
                                        ),
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                                            focusedLabelColor = MaterialTheme.colorScheme.primary,
                                            cursorColor = MaterialTheme.colorScheme.primary
                                        )
                                    )
                                    OutlinedTextField(
                                        value = Const.username,
                                        onValueChange = {
//                                            if (it.length <= maxChar) {
                                                username1 = it
//                                            }
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
                                        value = email12,
                                        onValueChange = {
//                                            if (it.length <= maxChar) {
                                                email12 = it
//                                            }
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 16.dp),
                                        label = { Text(text = "Email") },
                                        placeholder = { Text(text = "Your Email") },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Email,
                                            imeAction = ImeAction.Next
                                        ),
//                        trailingIcon = IconButton(onClick = { name = "" }) {
//                            Icon(
//                                imageVector = if (name.isNotEmpty()) Icons.Default.Cancel else Icons.Outlined.Cancel,
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
                                        value = phone_number1,
                                        onValueChange = {
//                                            if (it.length <= maxChar) {
                                                phone_number1 = it
//                                            }
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 16.dp),
                                        label = { Text(text = "Phone Number") },
                                        placeholder = { Text(text = "Your Phone Number") },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Phone,
                                            imeAction = ImeAction.Next
                                        ),
//                        trailingIcon = IconButton(onClick = { name = "" }) {
//                            Icon(
//                                imageVector = if (name.isNotEmpty()) Icons.Default.Cancel else Icons.Outlined.Cancel,
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
                                        value = dateofbirth1,
                                        onValueChange = {
//                                            if (it.length <= DATE_LENGTH) {
                                                dateofbirth1 = it
//                                            }
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 16.dp),
                                        label = { Text(text = "Date of Birth") },
                                        placeholder = { Text(text = "Enter your birthday") },
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Number,
                                            imeAction = ImeAction.Next
                                        ),
                                        singleLine = true,
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                                            focusedLabelColor = MaterialTheme.colorScheme.primary,
                                            cursorColor = MaterialTheme.colorScheme.primary
                                        ),
//                        visualTransformation = MaskVisualTransformation(DATE_MASK)
                                    )

                                    OutlinedTextField(
                                        value = password1,
                                        onValueChange = {
//                                            if (it.length <= maxChar) {
                                            password1 = it
//                                            }
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 16.dp),
                                        label = { Text(text = "Password") },
                                        placeholder = { Text(text = "Enter your password") },
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
//
                                }

                                val mContext = LocalContext.current
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 16.dp, 0.dp, 8.dp),
                                    onClick = {
                                        mainViewModel.patchUser(
                                            Const.user_id,name1,
                                            username1,
                                            email12,
                                            phone_number1,
                                            dateofbirth1,
                                           password1,
                                        )
                                        val intent = Intent(mContext, MainActivity::class.java)
                                        //   intent.putExtra("username", response.username)
                                        mContext.startActivity(intent)
//                    postDataUsingRetrofit(
//                        mContext,name,name,email,phone_number,dateofbirth,password,response
//                    )
                                        Toast.makeText(mContext, "Profile Edited", Toast.LENGTH_SHORT).show()
                                    }) {
                                    Text(text = "Save")
                                }


                            }


                        }

                    }
                }
            }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen1() { //kasih paraneter id
    lateinit var navController: NavController
    var name by rememberSaveable { mutableStateOf("") }
    var phone_number by rememberSaveable { mutableStateOf("") }
    val maxChar = 200
    //var mainViewModel = ViewModelProvider(th).get(MainViewModel::class.java)
//    mainViewModel.getUser(Const.user_id, Const.token)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState(), true, null, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, bottom = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, bottom = 8.dp)
                    .verticalScroll(state = rememberScrollState(), enabled = false)
            ) {
                Text(
                    modifier = Modifier.weight(5f),
                    text = "EditProfile",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Black,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    textAlign = TextAlign.Start,
                )
            }
//        Image(imageVector = , contentDescription = "User Profile")

                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        if (it.length <= maxChar) {
                            name = it
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
                    value = phone_number,
                    onValueChange = {
                        if (it.length <= maxChar) {
                            phone_number = it
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp),
                    label = { Text(text = "Phone Number") },
                    placeholder = { Text(text = "Your Phone Number") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
//                        trailingIcon = IconButton(onClick = { name = "" }) {
//                            Icon(
//                                imageVector = if (name.isNotEmpty()) Icons.Default.Cancel else Icons.Outlined.Cancel,
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

            val mContext = LocalContext.current
            Button(
                modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 8.dp)
                    .fillMaxWidth(),
                onClick = {
//                    postDataUsingRetrofit(
//                        mContext,name,name,email,phone_number,dateofbirth,password,response
//                    )

                    Toast.makeText(mContext, "Form: name is $name and phone number is $phone_number", Toast.LENGTH_SHORT).show()
                }) {
                Text(text = "Save")
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
//    EditProfileScreen()
}