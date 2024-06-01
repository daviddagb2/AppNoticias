package com.gonzalez.blanchard.newsapp.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_entity")
data class NewsEntity(
    @PrimaryKey val id:String,
    val title: String,
    val description: String,
    val url: String,
    val content: String,
    val imageUrl: String
)
