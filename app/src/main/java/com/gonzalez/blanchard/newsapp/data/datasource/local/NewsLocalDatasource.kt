package com.gonzalez.blanchard.newsapp.data.datasource.local

import com.gonzalez.blanchard.newsapp.data.datasource.local.dao.NewsDao
import com.gonzalez.blanchard.newsapp.data.datasource.local.entities.NewsEntity
import javax.inject.Inject

class NewsLocalDatasource @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend fun insertNews(newsEntity: NewsEntity){
        newsDao.insertNews(newsEntity)
    }

    suspend fun getNewsData(): List<NewsEntity>{
        return newsDao.getAllNewsItems()
    }

    suspend fun deleteNewsItem(newsEntity: NewsEntity){
        newsDao.deleteNewsItem(newsEntity)
    }

}