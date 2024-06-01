package com.gonzalez.blanchard.newsapp.data.datasource.remote


import com.gonzalez.blanchard.newsapp.data.datasource.remote.model.NewsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTeopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponseDto>

}