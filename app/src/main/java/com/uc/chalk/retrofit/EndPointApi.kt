package com.uc.chalk.retrofit

import com.google.gson.JsonObject
import com.uc.chalk.model.User
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST


interface EndPointApi {
    @POST("/users")
    fun postUser(@Body body: RequestBody): Call<User>

    @POST("/login")
    fun postLogin(@Body body: RequestBody): Call<User>

    @PATCH("/users")
    fun patchUser(@Body body: RequestBody): Call<User>

    @GET("/users")
    suspend fun getUsers(
    ): Response<JsonObject>


}