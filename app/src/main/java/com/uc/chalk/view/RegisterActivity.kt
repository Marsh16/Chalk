package com.uc.chalk.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.composable
import com.google.gson.JsonObject
import com.uc.chalk.helper.Const
import com.uc.chalk.model.User
import com.uc.chalk.retrofit.EndPointApi
import com.uc.chalk.view.theme.ChalkTheme
import com.uc.chalk.viewmodel.MainViewModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity  : ComponentActivity()  {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChalkTheme {
                //mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]


//                mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//                mainViewModel.postRegister()
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
            .verticalScroll(state = rememberScrollState(),true,null,false)
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
                var name by remember { mutableStateOf("") }
                var username by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var phone_number by remember { mutableStateOf("") }
                var dateofbirth by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var cpassword by remember { mutableStateOf("") }
                val response = remember {
                    mutableStateOf("")
                }

                BasicTextField(
                    value = name,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { name = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (name.isEmpty()) {
                                Text("Name")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },
                )
                BasicTextField(
                    value = username,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { username = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (username.isEmpty()) {
                                Text("Username")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                BasicTextField(
                    value = email,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { email = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (email.isEmpty()) {
                                Text("Email")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                BasicTextField(
                    value = phone_number,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { phone_number = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (phone_number.isEmpty()) {
                                Text("Phone Number")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                BasicTextField(
                    value = dateofbirth,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { dateofbirth = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (dateofbirth.isEmpty()) {
                                Text("Date Of Birth")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                BasicTextField(
                    value = password,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { password = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (password.isEmpty()) {
                                Text("Password")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                BasicTextField(
                    value = cpassword,
                    modifier = Modifier.padding(16.dp,16.dp),
                    onValueChange = { cpassword = it },decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .background(Color.LightGray, RoundedCornerShape(percent = 10))
                                .padding(16.dp, 16.dp)
                                .fillMaxWidth()
                        ) {

                            if (cpassword.isEmpty()) {
                                Text("Confirm Password")
                            }
                            innerTextField()  //<-- Add this
                        }
                    },

                    )
                val mContext = LocalContext.current
                Button(   modifier = Modifier
                    .padding(16.dp, 16.dp)
                    .fillMaxWidth(),
                    onClick = {
                        postDataUsingRetrofit(
                            mContext, name, username,email,phone_number,dateofbirth,password, response
                        )
                        Toast.makeText(mContext, "Form: name is $name and email is $email", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Log In",
                    )

                }
                Text(
                    text = "Have An Account? Login",
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

private fun postDataUsingRetrofit(
    ctx: Context,
    name: String,
    username: String,
    email: String,
    phone_number: String,
    dateofbirth: String,
    password: String,
    result: MutableState<String>
) {

    // on below line we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(Const.BASE_URL_LOCALHOST)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()
// below the line is to create an instance for our retrofit api class.
val retrofitAPI = retrofit.create(EndPointApi::class.java)
// passing data from our text fields to our model class.
val user = User(0,name, username, email,phone_number,dateofbirth,"", password)

    val requestBody: RequestBody = MultipartBody.Builder()
        .setType(MultipartBody.FORM)
        .addFormDataPart("name", user.name)
        .addFormDataPart("username", user.username)
        .addFormDataPart("email", user.email)
        .addFormDataPart("phone_number", user.phone_number)
        .addFormDataPart("dateofbirth", user.dateofbirth)
        .addFormDataPart("password", user.password)
        .build()

    val call = retrofitAPI.postUser(requestBody)

    call.enqueue(object : Callback<User> {
        override fun onFailure(call: Call<User>, t: Throwable) { }

        override fun onResponse(call: Call<User>,
                                response: retrofit2.Response<User>) {

        }
    })




}

