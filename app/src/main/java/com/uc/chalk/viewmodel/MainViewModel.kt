package com.uc.chalk.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.uc.chalk.helper.Const
import com.uc.chalk.model.User
import com.uc.chalk.repository.MainRepository
import com.uc.chalk.retrofit.EndPointApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel()  {

     //post register
    val _user: MutableLiveData<JsonObject> by lazy {
        MutableLiveData<JsonObject>()
    }

    val user: LiveData<JsonObject>
        get() = _user



    fun getUsers() = viewModelScope.launch {
        repository.getUsers().let { response ->
//            Log.d("Test", response.body().toString())
            if (response.isSuccessful) {
//
                _user.value= response.body()
                Log.e("status", _user.value!!.asJsonObject["status"].toString())
                val array: JsonArray =_user.value!!.getAsJsonArray("data")
//                for (jsonObj in array){
//                    val n =  jsonObj.asJsonObject["nim"].toString()
//                    Log.e("Test1", n)
//                }
                Log.d("Test", _user.value.toString())

                Log.d("Test", array.toString())
                // _mahasiswa.postValue(response.body())

            } else {
                Log.e("Get Movie Details Data", "Failed!")
            }
        }
    }
}