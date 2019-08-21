package com.example.tae_kotlin_api_movie_github.networkGit

import android.provider.SyncStateContract
import com.example.tae_kotlin_api_movie_github.Constants
import com.example.tae_kotlin_api_movie_github.viewGit.ConstantsGit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceGit {
    val retrofitInstances: Retrofit
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


            return Retrofit.Builder()
                .baseUrl(ConstantsGit.BASE_URL_GIT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}