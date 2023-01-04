package com.uc.chalk.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uc.chalk.view.theme.ui.firaSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() { //kasih paraneter id
    lateinit var navController: NavController
    var name by rememberSaveable { mutableStateOf("") }
    var phone_number by rememberSaveable { mutableStateOf("") }
    val maxChar = 200

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
                value = phone_number,
                onValueChange = {
                    if (it.length <= maxChar) {
                        phone_number = it
                    } },
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
    EditProfileScreen()
}