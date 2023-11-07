package com.danilkharytonov.data.network

import com.danilkharytonov.data.network.model.UsersNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInstance {
    @GET("api/")
    suspend fun getAllUsers(@Query("results") results: Int): UsersNetwork

    companion object {
        const val BASE_URL = "https://randomuser.me/"
    }
}