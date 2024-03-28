package com.example.mod7pony

import retrofit2.Call
import retrofit2.http.GET

interface PonyDaoService {
    @GET("free_bike_status.json")
    fun getPony() : Call<PonyResponse>
}