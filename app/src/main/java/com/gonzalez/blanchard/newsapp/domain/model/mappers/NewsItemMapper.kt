package com.gonzalez.blanchard.newsapp.domain.model.mappers

import com.gonzalez.blanchard.newsapp.data.datasource.local.entities.NewsEntity
import com.gonzalez.blanchard.newsapp.data.datasource.remote.model.NewsItemDto
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem
import com.google.gson.annotations.SerializedName


fun NewsItemDto.toDomain() = NewsItem(
    id = "",
    title = title ?: "",
    summary = description ?: "",
    content = content ?: "",
    imageUrl = imageUrl ?: "",
    url = url ?: ""
)

fun NewsEntity.toDomain() = NewsItem(
    id = id,
    title = title,
    summary = description,
    content = content,
    imageUrl = imageUrl,
    url = url
)