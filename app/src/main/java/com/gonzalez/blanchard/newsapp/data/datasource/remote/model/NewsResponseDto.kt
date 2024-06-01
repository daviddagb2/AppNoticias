package com.gonzalez.blanchard.newsapp.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class NewsResponseDto(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<NewsItemDto> = emptyList()
)
