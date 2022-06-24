package com.example.recyclerapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val Url = "https://reqres.in/api/"

    fun RetrofitService() : RetrofitRepository {
        return Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitRepository::class.java)
    }
}