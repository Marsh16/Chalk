package com.uc.chalk.retrofit

import com.google.gson.JsonObject
import com.uc.chalk.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query


interface EndPointApi {
    @GET("/cekuserexist")
    suspend fun getcekuser(
        @Query("username") username: String
    ): Response<JsonObject>

    @POST("/users")
    suspend fun postUser(
        @Query("name") name: String,
        @Query("username") username: String,
        @Query("email") email: String,
        @Query("phone_number") phone_number: String,
        @Query("dateofbirth") dateofbirth: String,
        @Query("profilepic") profilepic: String,
        @Query("password") password: String,
    ): Response<User>

    @GET("/login")
    suspend fun getLogin(
        @Query("username") username: String,
        @Query("password") password: String,
    ): Response<Token>

    @GET("/loginsuccess")
    suspend fun getUser(
        @Query("user_id") user_id: String,
        @Header("Authorization") token: String,
    ): Response<User>

    @GET("/fetchusername")
    suspend fun getUserbyusername(
        @Query("username") username: String,
    ): Response<Login>

    @GET("/fetchcontactbyuserid")
    suspend fun getContact(
        @Query("user_id") user_id: String,
    ): Response<ContactList>


}