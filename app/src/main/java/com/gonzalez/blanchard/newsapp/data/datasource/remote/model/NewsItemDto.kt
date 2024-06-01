package com.gonzalez.blanchard.newsapp.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class NewsItemDto(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("urlToImage") val imageUrl: String?
)


