package com.uc.chalk.view.auth

//import com.uc.chalk.view.theme.ChalkTheme
//import com.uc.chalk.helper.MaskVisualTransformation
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uc.chalk.helper.Const
import com.uc.chalk.helper.DATE_LENGTH
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun a() {
        Box(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState(), true, null, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)) {
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
                var name by rememberSaveable { mutableStateOf("") }
                var username by rememberSaveable { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var phone_number by rememberSaveable { mutableStateOf("") }
                var dateofbirth by rememberSaveable { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }
                var cpassword by rememberSaveable { mutableStateOf("") }
                val response = remember { mutableStateOf("") }
                var passwordVisibility by remember { mutableStateOf(false) }
                val passIcon = if (passwordVisibility)
                    painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
                else
                    painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
                val cancelIcon = painterResource(id = com.google.android.material.R.drawable.mtrl_ic_cancel)
                val maxChar = 200
                val minPass = 8
                Column(modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)) {
                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            if (it.length <= maxChar) {
                                name = it
                            }
                        },
                        label = {Text(text = "Name")},
                        placeholder = { Text(text = "Enter your name")},
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
                        value = email,
                        onValueChange = {
                            if (it.length <= maxChar) {
                                email = it
                            }
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
                    OutlinedTextField(
                        value = dateofbirth,
                        onValueChange = {
                            if (it.length <= DATE_LENGTH) {
                                dateofbirth = it
                            }
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
//                    BasicTextField(
//                        value = dateofbirth,
//                        modifier = Modifier.padding(0.dp,16.dp),
//                        onValueChange = { dateofbirth = it },decorationBox = { innerTextField ->
//                            Row(
//                                Modifier
//                                    .background(MaterialTheme.colorScheme.background)
//                                    .border(
//                                        2.dp,
//                                        MaterialTheme.colorScheme.onBackground,
//                                        RoundedCornerShape(4.dp)
//                                    )
//                                    .padding(16.dp)
//                                    .fillMaxWidth()
//                            ) {
//                                if (dateofbirth.isEmpty()) {
//                                    Text("Your Birthday")
//                                }
//                                innerTextField()  //<-- Add this
//                            }
//                        },
//                    )
                    OutlinedTextField(
                        value = password,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 16.dp),
                        singleLine = true,
                        onValueChange = {
                            if (it.length >= minPass) {
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
                    OutlinedTextField(
                        value = cpassword,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 16.dp),
                        singleLine = true,
                        onValueChange = {
                            if (it.length >= minPass) {
                                if (it == password) {
                                    cpassword = it
                                }
                            }
                        },
                        placeholder = { Text(text = "Confirm your password") },
                        label = { Text(text = "Confirm Password")},
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
                            imeAction = ImeAction.Done
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                }

                val mContext = LocalContext.current
                Button(
                    modifier = Modifier
                        .padding(0.dp, 16.dp, 0.dp, 8.dp)
                        .fillMaxWidth(),
                    onClick = {
                        postDataUsingRetrofit(
                            mContext,name,username,email,phone_number,dateofbirth,password,response
                        )
                        Toast.makeText(mContext, "Form: name is $name and email is $email", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Register")
                }
                Row {
                    Spacer(modifier = Modifier
                        .weight(1f)
                        .padding(0.dp, 0.dp, 0.dp, 16.dp))
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