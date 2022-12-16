package com.uc.chalk.repository

import com.uc.chalk.retrofit.EndPointApi
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: EndPointApi){



    suspend fun getUsers() = api.getUsers()

}