package com.uc.chalk.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.uc.chalk.helper.Const
import com.uc.chalk.model.Contact
import com.uc.chalk.model.Login
import com.uc.chalk.model.Token
import com.uc.chalk.model.User
import com.uc.chalk.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel()  {

     //cek user exist
     val _cek: MutableLiveData<JsonObject> by lazy {
         MutableLiveData<JsonObject>()
     }

    val cek: LiveData<JsonObject>
        get() = _cek
    fun getcekuser(username: String) = viewModelScope.launch {
        repository.getcekuser(username).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {
                _cek.postValue(
                    response.body()
                )
                Log.e("message", response.message())
                Const.userfail=""

            } else {
                _cek.postValue(
                    response.body()
                )
                Log.e("Cek user exist",response.message())
                Const.userfail="Unauthorized"
            }
        }
    }


    //register
//    val _user: MutableLiveData<ArrayList<User>> by lazy {
//                MutableLiveData<ArrayList<User>>()
//    }
//
//    val user: LiveData<ArrayList<User>>
//        get() = _user

    fun postUser(name: String,username: String, email: String, phone_number: String,dateofbirth: String, profilepic: String, password: String) = viewModelScope.launch {
        repository.postUser(name,username,email,phone_number,dateofbirth,profilepic,password).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("Register", response.toString())


            } else {
                Log.e("Register failed", response.toString())
            }
        }
    }

    //cek user exist
    val _token: MutableLiveData<Token> by lazy {
        MutableLiveData<Token>()
    }

    val token: LiveData<Token>
        get() = _token

    fun getLogin(username: String,password: String) = viewModelScope.launch {
        repository.getLogin(username,password).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {
                _token.postValue(
                response.body() as Token
                )

                Log.e("message", response.message())
                Log.e("isinya", response.body()!!.token)
                Const.userfail=""
//                Const.token= response.body()!!.token

            } else {
                Log.e("cek token",response.message())
                Const.userfail="Internal Server Error"

            }
        }
    }
    //cek username
    val _username: MutableLiveData<Login> by lazy {
        MutableLiveData<Login>()
    }

    val username: LiveData<Login>
        get() = _username
    fun getUserbyusername(username: String) = viewModelScope.launch {
        repository.getUserbyusername(username).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {
                //val array: JsonArray =_mahasiswa.value!!.getAsJsonArray("data")
                _username.postValue(
                    response.body() as Login
                )
                Log.e("user_id", response.body()!!.data.toString())
                Const.user_id= response.body()!!.data
                Const.userfail=""

            } else {

                Log.e("username by get user",response.message())
                Const.userfail="Internal Server Error"
            }
        }
    }
    //cek username
    val _user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    val user: LiveData<User>
        get() = _user
    fun getUser(user_id: String,token:String) = viewModelScope.launch {
        repository.getUser(user_id,token).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {
                //val array: JsonArray =_mahasiswa.value!!.getAsJsonArray("data")
                _user.postValue(
                    response.body() as User
                )


                Const.userfail=""

            } else {

                Log.e("username by get user",response.message())
                Const.userfail="Internal Server Error"
            }
        }
    }


//get contact
val _contact: MutableLiveData<ArrayList<Contact>> by lazy {
    MutableLiveData<ArrayList<Contact>>()
}

val contact: LiveData<ArrayList<Contact>>
    get() = _contact
fun getContact(user_id: String) = viewModelScope.launch {
    repository.getContact(user_id).let { response ->
//            Log.d("Test", response.body().toString())

        if (response.isSuccessful) {
//            val array: JsonArray =_mahasiswa.value!!.getAsJsonArray("data")
            _contact.postValue(
                response.body()?.contact as
                            ArrayList<Contact>?
            )
            for (i in 0 until response.body()!!.contact.size) {
                val new = Contact(
                    Const.contacts.get(i).id,
                Const.contacts.get(i).name,
                Const.contacts.get(i).phone_number,
                Const.contacts.get(i).profilepic,
                Const.contacts.get(i).user_id,
                )

                Const.contacts.add(new)
            }



        } else {

            Log.e("fail","failed")

        }
    }
}
}