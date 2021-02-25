package com.example.newsapplication.core.api

import com.example.newsapplication.core.model.NewsResponse
import com.example.newsapplication.ui.constans.Constants.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RetrofitAPI::class.java)

    fun getData() : Call<NewsResponse>{
        return api.fetchData()
    }

}