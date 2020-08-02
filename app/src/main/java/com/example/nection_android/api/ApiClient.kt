package com.example.nection_android.api

import com.example.nection_android.BuildConfig
import com.squareup.moshi.Moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        // こんな感じにすると汎用的に使えます！
        fun getClient(): Retrofit {
            val client = buildHttpClient()
            val moshi = Builder().add(KotlinJsonAdapterFactory()).build()

            return Retrofit.Builder()
                .baseUrl(ApiConfig.baseURL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
        }

        private fun buildHttpClient(): OkHttpClient {
            val client = OkHttpClient.Builder().readTimeout(60000, TimeUnit.MILLISECONDS)
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(logging)
            }

            return client.build()
        }
    }
}