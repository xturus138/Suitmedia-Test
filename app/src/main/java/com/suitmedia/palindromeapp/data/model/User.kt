package com.suitmedia.palindromeapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
) : Parcelable
