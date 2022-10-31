package com.example.allinonegame.apicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        var baseurl = "https://restcountries.com/v2/"

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}