package com.example.nection_android.api

import com.example.nection_android.BuildConfig
import com.example.nection_android.api.endpoint.PhoneAuthApis
import com.squareup.moshi.Moshi
import com.squareup.moshi.Moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        // エンドポイントごとにこんな感じで関数を作らなきゃいけないのかが少し疑問…
        fun postPhoneNumber(): PhoneAuthApis {
            val client = buildHttpClient()
            // ここでなぜかつまずく？？
            val moshi = Builder().add(KotlinJsonAdapterFactory()).build()
            val retrofit = Retrofit.Builder()
                .baseUrl(ApiConfig.baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()

            return retrofit.create(PhoneAuthApis::class.java)
        }

        private fun buildHttpClient(): OkHttpClient {
            val client = OkHttpClient.Builder().readTimeout(60000,  TimeUnit.MILLISECONDS)
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(logging)
            }

            return client.build()
        }
    }
}