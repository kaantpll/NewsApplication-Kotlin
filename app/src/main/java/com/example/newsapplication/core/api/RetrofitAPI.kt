package com.example.newsapplication.core.api

import com.example.newsapplication.core.model.NewsResponse
import com.example.newsapplication.ui.constans.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("top-headlines?country=tr&apiKey=$API_KEY")
    fun fetchData() : Call<NewsResponse>

}