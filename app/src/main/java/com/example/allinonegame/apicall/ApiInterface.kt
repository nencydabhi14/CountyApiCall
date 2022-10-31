package com.example.allinonegame.apicall

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("all")
    fun getData() : Call<List<CountyModelItem>>
}