package com.gonzalez.blanchard.newsapp.domain.model

data class NewsItem(
    val id: String,
    val title: String,
    val summary: String,
    val content: String,
    val imageUrl: String,
    val url: String
)
