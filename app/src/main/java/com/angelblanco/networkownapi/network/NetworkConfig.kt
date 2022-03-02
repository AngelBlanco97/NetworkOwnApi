package com.angelblanco.networkownapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.56.1:4000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            val service: ApiService = retrofit.create(ApiService::class.java)
}