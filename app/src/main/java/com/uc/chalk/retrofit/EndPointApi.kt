package com.uc.chalk.retrofit

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET

interface EndPointApi {
    @GET("/mahasiswa")
    suspend fun getMahasiswa(
    ): Response<JsonObject>
}