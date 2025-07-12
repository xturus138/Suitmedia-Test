package com.suitmedia.palindromeapp.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>
)