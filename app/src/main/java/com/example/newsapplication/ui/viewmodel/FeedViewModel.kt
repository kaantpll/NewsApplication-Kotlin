package com.example.newsapplication.ui.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapplication.core.api.RetrofitService
import com.example.newsapplication.core.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel : ViewModel() {

    private val apiService = RetrofitService()

    val newsList = MutableLiveData<NewsResponse>()

    fun fetchDataFromAPI(){

        apiService.getData().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {

                if(response.isSuccessful){
                    response?.body()?.let {
                        newsList.value = it
                    }
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}