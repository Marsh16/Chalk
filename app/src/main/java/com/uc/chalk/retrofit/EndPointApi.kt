package com.uc.chalk.retrofit

import com.google.gson.JsonObject
import com.uc.chalk.helper.Const
import com.uc.chalk.model.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
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

    @POST("/contacts")
    suspend fun postContact(
        @Query("name") name: String,
        @Query("phone_number") phone_number: String,
        @Query("profilepic") profilepic: String,
        @Query("user_id") user_id: String,
    ): Response<Contact>

    @POST("/chats")
    suspend fun postChat(
        @Query("contact_id") contact_id: String,
    ): Response<Chat>

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
    ): Response<JsonObject>

    @DELETE("/contacts")
    suspend fun deleteContact(
        @Query("contact_id") contact_id: String,
    ): Response<Contact>

//    @GET("/fetchcontactbyuserid")
//    suspend fun getContacts(
//        @Query("user_id") user_id: String
//    ) : List<Contact>
@GET("/fetchchatbyuserid")
suspend fun getChat(
    @Query("user_id") user_id: String,
    ): Response<JsonObject>

    @PATCH("/users")
    suspend fun patchUser(
        @Query("user_id") user_id: String,
        @Query("name") name: String,
        @Query("username") username: String,
        @Query("email") email: String,
        @Query("phone_number") phone_number: String,
        @Query("dateofbirth") dateofbirth: String,
        @Query("password") password: String,
    ): Response<User>


    @PATCH("/contacts")
    suspend fun patchContact(
        @Query("contact_id") contact_id: String,
        @Query("name") name: String,
        @Query("phone_number") phone_number: String,
        @Query("profilepic") profilepic: String,
        @Query("user_id") user_id: String,
    ): Response<Contact>

    @GET("/fetchmessage")
    suspend fun getMessage(
        @Query("contact_id") contact_id: String,
    ): Response<JsonObject>

    @POST("/messages")
    suspend fun postMessage(
        @Query("messages") messages: String,
        @Query("contact_id") contact_id: String,
    ): Response<JsonObject>

    @GET("/fetchallchatbyuserid")
    suspend fun getChatall(
        @Query("user_id") user_id: String,
    ): Response<JsonObject>


}