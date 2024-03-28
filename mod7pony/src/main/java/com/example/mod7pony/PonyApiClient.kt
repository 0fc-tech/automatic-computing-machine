package com.example.mod7pony

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PonyApiClient {
    const val BASE_URL = "https://gbfs.getapony.com/v1/Angers/fr/"

    val client : PonyDaoService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create()
}