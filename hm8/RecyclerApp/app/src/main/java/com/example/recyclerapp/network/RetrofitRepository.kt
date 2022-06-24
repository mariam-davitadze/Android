package com.example.recyclerapp.network

import com.example.recyclerapp.model.UsersListResponse
import retrofit2.http.GET


interface RetrofitRepository {
    @GET("users?page=2")
    suspend fun getUsersList(): retrofit2.Response<UsersListResponse>
}