package com.suitmedia.palindromeapp.data.repository

import com.suitmedia.palindromeapp.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UserService {
    @GET("api/users")
    suspend fun getUsers(
        @Header("x-api-key") apiKey: String = "reqres-free-v1",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10
    ): UserResponse
}