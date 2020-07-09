package com.example.nection_android.model

import com.squareup.moshi.Json

data class PhoneAuthResponse(
    @Json(name = "message") var message: String
)