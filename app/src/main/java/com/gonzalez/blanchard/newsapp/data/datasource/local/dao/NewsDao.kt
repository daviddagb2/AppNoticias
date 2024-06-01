package com.gonzalez.blanchard.newsapp.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gonzalez.blanchard.newsapp.data.datasource.local.entities.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_entity")
    fun getAllNewsItems(): List<NewsEntity>

    @Insert
    fun insertNews(newsEntity: NewsEntity)

    @Delete
    fun deleteNewsItem(newsEntity: NewsEntity)

    @Query("DELETE FROM news_entity WHERE id = :id")
    fun deleteById(id: String)

}