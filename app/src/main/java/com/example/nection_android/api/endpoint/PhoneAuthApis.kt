package com.example.nection_android.api.endpoint

import retrofit2.http.*

interface PhoneAuthApis {
    @FormUrlEncoded
    @POST("v1/auths")
    fun phoneAuth(@Query("phoneNumber") phoneNumber: String,
                  @Query("countryCode") countryCode: Int
    )
}