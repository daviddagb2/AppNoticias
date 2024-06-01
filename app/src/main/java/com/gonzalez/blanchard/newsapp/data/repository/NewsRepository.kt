package com.gonzalez.blanchard.newsapp.data.repository

import com.gonzalez.blanchard.newsapp.data.datasource.local.NewsLocalDatasource
import com.gonzalez.blanchard.newsapp.data.datasource.remote.NewsDS
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem
import com.gonzalez.blanchard.newsapp.domain.model.mappers.toDomain
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDS: NewsDS,
    private val newsLocalDs: NewsLocalDatasource
){

    suspend fun getTopNews(
        country: String,
        apiKey: String
    ): List<NewsItem> {
        return newsDS.getTopNews(
            country,
            apiKey
        ).toDomain().articles
    }

    suspend fun getNewsFromDatabase(): List<NewsItem>{
        return newsLocalDs.getNewsData().map{ it.toDomain() }
    }

}