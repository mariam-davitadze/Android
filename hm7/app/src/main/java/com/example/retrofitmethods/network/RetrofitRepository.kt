package com.example.retrofitmethods.network

import com.example.retrofitmethods.model.*
import retrofit2.Response
import retrofit2.http.*

interface RetrofitRepository {
    @POST("users")
    suspend fun addUserData(@Body user: User):Response<UserResponse>

    @GET("users/2")
    suspend fun getSingleUser():Response<SingleUserDataResponse>

    @PUT("users/2")
    suspend fun updateUser(@Body user: User):Response<UpdateUserResponse>

    @DELETE("users/2")
    suspend fun deleteUser(@Body user: User):Response<DeletedUserResponse>
}