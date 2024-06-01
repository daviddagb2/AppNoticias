package com.gonzalez.blanchard.newsapp.domain.model

data class NewsResponseItem(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsItem> = emptyList()
)