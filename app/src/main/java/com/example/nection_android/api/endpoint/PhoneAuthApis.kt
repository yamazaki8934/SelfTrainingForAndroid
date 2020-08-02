package com.example.nection_android.api.endpoint

import com.example.nection_android.model.PhoneAuthResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface PhoneAuthApis {
    @POST("v1/auths")
    fun phoneAuth(@Query("phoneNumber") phoneNumber: String,
                  @Query("countryCode") countryCode: Int
    ): Single<Response<PhoneAuthResponse>>
}