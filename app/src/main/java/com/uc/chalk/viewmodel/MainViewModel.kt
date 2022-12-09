package com.uc.chalk.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.uc.chalk.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel()  {
    // get mahasiswa
    val _mahasiswa: MutableLiveData<JsonObject> by lazy {
        MutableLiveData<JsonObject>()
    }

    val mahasiswa: LiveData<JsonObject>
        get() = _mahasiswa



    fun getMahasiswaData() = viewModelScope.launch {
        repository.getMahasiswaResults().let { response ->
//            Log.d("Test", response.body().toString())
            if (response.isSuccessful) {
//
                _mahasiswa.value= response.body()
                Log.e("status", _mahasiswa.value!!.asJsonObject["status"].toString())
                val array: JsonArray =_mahasiswa.value!!.getAsJsonArray("data")
                for (jsonObj in array){
                    val n =  jsonObj.asJsonObject["nim"].toString()
                    Log.e("Test1", n)
                }
                Log.d("Test", _mahasiswa.value.toString())

                Log.d("Test", array.toString())
                // _mahasiswa.postValue(response.body())

            } else {
                Log.e("Get Movie Details Data", "Failed!")
            }
        }
    }
}