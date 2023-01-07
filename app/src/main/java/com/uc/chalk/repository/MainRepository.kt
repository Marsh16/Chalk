package com.uc.chalk.repository

import com.uc.chalk.retrofit.EndPointApi
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: EndPointApi){

    suspend fun getcekuser(username: String)= api.getcekuser(username)
    suspend fun postUser(name: String,username: String, email: String,phone_number: String, dateofbirth: String, profilepic: String, password: String )= api.postUser(name, username,email,phone_number,dateofbirth,profilepic,password)
    suspend fun postMessage(messages: String,contact_id: String)= api.postMessage(messages, contact_id)
    suspend fun postChat(contact_id: String)= api.postChat(contact_id)
    suspend fun postContact(name: String,phone_number: String, profilepic: String,user_id: String)= api.postContact(name, phone_number,profilepic, user_id)
    suspend fun getLogin(username: String,password: String)= api.getLogin(username,password)
    suspend fun getUser(user_id: String,token: String)= api.getUser(user_id,token)
    suspend fun getUserbyusername(username: String)= api.getUserbyusername(username)
    suspend fun getContact(user_id: String)= api.getContact(user_id)
    suspend fun getChat(user_id: String)= api.getChat(user_id)
    suspend fun deleteContact(contact_id: String)= api.deleteContact(contact_id)
    suspend fun getMessage(contact_id: String)= api.getMessage(contact_id)
    suspend fun patchUser(user_id: String,name: String,username: String, email: String,phone_number: String, dateofbirth: String,password: String )= api.patchUser(user_id,name, username,email,phone_number,dateofbirth,password)
    suspend fun patchContact(contact_id: String,name: String,phone_number: String, profilepic: String,user_id: String )= api.patchContact(contact_id,name, phone_number,profilepic,user_id)
}