package com.betrybe.trybnb.data.api

import com.betrybe.trybnb.data.models.LoginRequest
import com.betrybe.trybnb.data.models.LoginResponse
import com.betrybe.trybnb.data.models.UrlParameter
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth")
    suspend fun loginAuthentication(@Body requestBody: LoginRequest): Response<LoginResponse>

    @GET("booking")
    suspend fun getBookingList(): Response<List<UrlParameter>>

}