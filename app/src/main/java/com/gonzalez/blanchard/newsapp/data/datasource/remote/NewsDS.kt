package com.gonzalez.blanchard.newsapp.data.datasource.remote

import com.gonzalez.blanchard.newsapp.data.datasource.remote.implementation.NewsApiServiceImpl
import com.gonzalez.blanchard.newsapp.data.datasource.remote.model.NewsResponseDto
import com.gonzalez.blanchard.newsapp.utils.parseResponse
import javax.inject.Inject

class NewsDS @Inject constructor(
    private val newsApi: NewsApiServiceImpl
){

    suspend fun getTopNews(
        country: String,
        apiKey: String
    ): NewsResponseDto{
       return newsApi.getTopNews(country,apiKey).parseResponse()
    }

}