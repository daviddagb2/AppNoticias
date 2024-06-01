package com.gonzalez.blanchard.newsapp.data.datasource.remote.implementation

import com.gonzalez.blanchard.newsapp.data.datasource.remote.NewsApiService
import com.gonzalez.blanchard.newsapp.data.datasource.remote.model.NewsResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NewsApiServiceImpl @Inject constructor(
    private val api: NewsApiService
) {

    suspend fun getTopNews(
        country: String,
        apiKey: String
    ): Response<NewsResponseDto> {
        return withContext(Dispatchers.IO){
            api.getTeopHeadlines(country, apiKey)
        }
    }

}