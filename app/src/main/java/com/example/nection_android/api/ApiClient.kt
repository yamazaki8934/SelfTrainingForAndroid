package com.example.nection_android.api

import com.example.nection_android.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    fun getClient(): Retrofit {
        val clientBuilder = OkHttpClient.Builder()

        return Retrofit.Builder()
            .baseUrl(ApiConfig.baseURL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }
}