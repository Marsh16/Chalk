package com.uc.chalk.view.auth

//import com.uc.chalk.view.theme.ChalkTheme
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import com.uc.chalk.helper.Const
import com.uc.chalk.model.User
import com.uc.chalk.retrofit.EndPointApi
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
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
            .verticalScroll(state = rememberScrollState(), true, null, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)) {
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
                    text = "Register",
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier.padding(0.dp,16.dp))
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
                Column(modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)) {
                    BasicTextField(
                        value = name,
                        modifier = Modifier.padding(0.dp,16.dp),
                        onValueChange = { name = it },
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

                                if (name.isEmpty()) {
                                    Text("Your Name")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                    BasicTextField(
                        value = username,
                        modifier = Modifier.padding(0.dp,16.dp),
                        singleLine = true,
                        onValueChange = { username = it },
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
                                    Text("Your Username")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                    BasicTextField(
                        value = email,
                        modifier = Modifier.padding(0.dp,16.dp),
                        onValueChange = { email = it },
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

                                if (email.isEmpty()) {
                                    Text("Your Email")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                    BasicTextField(
                        value = phone_number,
                        modifier = Modifier.padding(0.dp,16.dp),
                        onValueChange = { phone_number = it },decorationBox = { innerTextField ->
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

                                if (phone_number.isEmpty()) {
                                    Text("Your Phone Number")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                    BasicTextField(
                        value = dateofbirth,
                        modifier = Modifier.padding(0.dp,16.dp),
                        onValueChange = { dateofbirth = it },decorationBox = { innerTextField ->
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
                                if (dateofbirth.isEmpty()) {
                                    Text("Your Birthday")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                    BasicTextField(
                        value = password,
                        modifier = Modifier.padding(0.dp,16.dp),
                        singleLine = true,
                        onValueChange = { password = it },
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
                                    Text("Password")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                    BasicTextField(
                        value = cpassword,
                        modifier = Modifier.padding(0.dp,16.dp),
                        singleLine = true,
                        onValueChange = { cpassword = it },
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

                                if (cpassword.isEmpty()) {
                                    Text("Confirm Password")
                                }
                                innerTextField()  //<-- Add this
                            }
                        },
                    )
                }

                val mContext = LocalContext.current
                Button(
                    modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 8.dp)
                    .fillMaxWidth(),
                    onClick = {
                        postDataUsingRetrofit(
                            mContext,name,username,email,phone_number,dateofbirth,password, response
                        )
                        Toast.makeText(mContext, "Form: name is $name and email is $email", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Register")
                }
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Already Have An Account? ",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Log in",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 12.sp,
                        modifier = Modifier.clickable {
                            val intent = Intent(mContext, LoginActivity::class.java)
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

