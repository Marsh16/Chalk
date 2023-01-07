package com.uc.chalk.viewmodel

//import com.uc.chalk.view.ContactList
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.uc.chalk.helper.Const
import com.uc.chalk.model.*
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

    fun postChat(contact_id: String) = viewModelScope.launch {
        repository.postChat(contact_id).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("add chat", response.toString())


            } else {
                Log.e("Register failed", response.toString())
            }
        }
    }
    fun postMessage(message: String,contact_id: String) = viewModelScope.launch {
        repository.postMessage(message,contact_id).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("message post", response.toString())


            } else {
                Log.e("Register failed", response.toString())
            }
        }
    }

    fun deleteContact(contact_id: String) = viewModelScope.launch {
        repository.deleteContact(contact_id).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("message post", response.toString())


            } else {
                Log.e("Register failed", response.toString())
            }
        }
    }

    fun postContact(name: String,phone_number: String,profilepic: String,username: String ) = viewModelScope.launch {
        repository.postContact(name,phone_number,profilepic,username).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("message post", response.toString())


            } else {
                Log.e("Register failed", response.toString())
            }
        }
    }


    fun patchContact(contact_id: String,name: String,phone_number: String,profilepic: String,username: String ) = viewModelScope.launch {
        repository.patchContact(contact_id,name,phone_number,profilepic,username).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("message post", response.toString())


            } else {
                Log.e("Register failed", response.toString())
            }
        }
    }


    fun patchUser(user_id: String,name: String,username: String, email: String, phone_number: String,dateofbirth: String,password: String) = viewModelScope.launch {
        repository.patchUser(user_id,name,username,email,phone_number,dateofbirth,password).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {

                Log.e("edit profile", response.toString())


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
//                Const.name="response.body()!!.name".toString()
//                Const.email="response.body()!!.email".toString()
//                Const.phone_number="response.body()!!.phone_number".toString()
//                Const.dateofbirth=response.body()!!.dateofbirth.toString()
//                Const.password=response.body()!!.password.toString()

                Const.userfail=""

            } else {

                Log.e("username by get user",response.message())
                Const.userfail="Internal Server Error"
            }
        }
    }


//get contact
val _contact: MutableLiveData<JsonObject> by lazy {
    MutableLiveData<JsonObject>()
}

val contact: LiveData<JsonObject>
    get() = _contact
fun getContact(user_id: String) = viewModelScope.launch {
    repository.getContact(user_id).let { response ->
//            Log.d("Test", response.body().toString())

        if (response.isSuccessful) {
//            val array: JsonArray =_mahasiswa.value!!.getAsJsonArray("data")

            //val list: ArrayList<Contact> = ArrayList()

            val array: JsonArray=  response.body()!!.getAsJsonArray("data")
            Log.e("data", array.toString())
            for (jsonObj in array){

                val id =  jsonObj.asJsonObject["contact_id"].toString()
                Const.contact_id=id.toString()
                val name =  jsonObj.asJsonObject["name"].toString()
                val phone_number =  jsonObj.asJsonObject["phone_number"].toString()
                val profilepic =  jsonObj.asJsonObject["profilepic"].toString()
                val user_id =  jsonObj.asJsonObject["user_id"].toString()
                Log.e("Test1", name)
                val re = "[^A-Za-z0-9 ]".toRegex()

                val add=Contact(re.replace(id, "").toInt(),re.replace(name, ""),re.replace(phone_number, ""),re.replace(profilepic, ""),re.replace(user_id, ""))
//              val add=Contact(id.asInt,name,phone_number,profilepic,user_id)
                if ( Const.contacts.size>1){
                    Const.contacts.clear()
                }
              Const.contacts.add(add)
            }
//            array as ArrayList<Contact>

            _contact.postValue(
                response.body()
            )

            Log.e("fail",  response.body().toString())
//            for (i in 0 until response.body()!!.contact.size) {
//                val new = Contact(
//                    Const.contacts.get(i).id,
//                Const.contacts.get(i).name,
//                Const.contacts.get(i).phone_number,
//                Const.contacts.get(i).profilepic,
//                Const.contacts.get(i).user_id,
//                )
//
//                Const.contacts.add(new)
//                Log.e("fail",Const.contacts[i].name)
//            }



        } else {

            Log.e("fail","failed")

        }
    }
}
    val _messages: MutableLiveData<JsonObject> by lazy {
        MutableLiveData<JsonObject>()
    }

    val messages: LiveData<JsonObject>
        get() = _messages
    fun getMessage(contact_id: String) = viewModelScope.launch {
        repository.getMessage(contact_id).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {
//            val array: JsonArray =_mahasiswa.value!!.getAsJsonArray("data")

                //val list: ArrayList<Contact> = ArrayList()
if (!response.body()!!.getAsJsonArray("data").isJsonNull){

    val array: JsonArray=  response.body()!!.getAsJsonArray("data")
    Log.e("data", array.toString())
    for (jsonObj in array){


        val id =  jsonObj.asJsonObject["messages_id"].toString()
        val messages =  jsonObj.asJsonObject["messages"].toString()
        val contact_id =  jsonObj.asJsonObject["contact_id"].toString()
        val re = "[^A-Za-z0-9 ]".toRegex()

        val add=Message(re.replace(id, "").toInt(),re.replace(messages, ""),re.replace(contact_id, ""))
//        if ( Const.messages.size>1){
//            Const.messages.clear()
//        }
        Log.e("Test1", messages)
            Const.messages.add(add)


    }
}
//                val array: JsonArray=  response.body()!!.getAsJsonArray("data")
//                Log.e("data", array.toString())
//                for (jsonObj in array){
//                    val id =  jsonObj.asJsonObject["messages_id"]
//                    val messages =  jsonObj.asJsonObject["messages"].toString()
//                    val contact_id =  jsonObj.asJsonObject["contact_id"].toString()
//                    Const.contact_id=contact_id
//                    Log.e("Test1", messages)
//                    val add=Message(id.asInt,messages,contact_id)
//                    Const.messages.add(add)
//                }
//            array as ArrayList<Contact>

                _messages.postValue(
                    response.body()
                )

                Log.e("fail",  response.body().toString())
//            for (i in 0 until response.body()!!.contact.size) {
//                val new = Contact(
//                    Const.contacts.get(i).id,
//                Const.contacts.get(i).name,
//                Const.contacts.get(i).phone_number,
//                Const.contacts.get(i).profilepic,
//                Const.contacts.get(i).user_id,
//                )
//
//                Const.contacts.add(new)
//                Log.e("fail",Const.contacts[i].name)
//            }



            } else {

                Log.e("fail","failed")

            }
        }
    }
    val _chat: MutableLiveData<JsonObject> by lazy {
        MutableLiveData<JsonObject>()
    }
    val chat: LiveData<JsonObject>
        get() = _chat
    fun getChat(user_id: String) = viewModelScope.launch {
        repository.getChat(user_id).let { response ->
//            Log.d("Test", response.body().toString())

            if (response.isSuccessful) {
//
                val array: JsonArray=  response.body()!!.getAsJsonArray("data")
                Log.e("data", array.toString())
//
                for (jsonObj in array){

                    val id =  jsonObj.asJsonObject["id"].toString()
                    val phone_number =  jsonObj.asJsonObject["phone_number"].toString()
                    val name =  jsonObj.asJsonObject["name"].toString()
                    val profilepic =  jsonObj.asJsonObject["profilepic"].toString()
                    val user_id =  jsonObj.asJsonObject["user_id"].toString()
                    val contact_id =  jsonObj.asJsonObject["contact_id"].toString()
                    Log.e("Test1", name)
                    val re = "[^A-Za-z0-9 ]".toRegex()

                    val add=Chat(re.replace(id, "").toInt(),re.replace(name, ""),re.replace(phone_number, ""),re.replace(profilepic, ""),re.replace(user_id, ""),re.replace(contact_id, ""))
//                    val add=Data(id.asInt,name,phone_number,profilepic,user_id,contact_id)
                    if ( Const.chats.size>1) {
//                    //  Const.chats.clear()
                        Const.chats.clear()
                    }
                        Const.chats.add(add)

//                }

                }
//            array as ArrayList<Contact>


                _chat.postValue(
                    response.body()
                )
//                            for (i in 0 until response.body()!!.data.size) {
//                val new = Data(
//                    Const.contacts.get(i).id,
//                Const.contacts.get(i).name,
//                Const.contacts.get(i).phone_number,
//                Const.contacts.get(i).profilepic,
//                Const.contacts.get(i).user_id,
//                )
//
//                Const.contacts.add(new)
//                Log.e("fail",Const.contacts[i].name)
//            }


                Log.e("fail",  response.body().toString())

            } else {

                Log.e("fail","failed")

            }
        }
    }
}