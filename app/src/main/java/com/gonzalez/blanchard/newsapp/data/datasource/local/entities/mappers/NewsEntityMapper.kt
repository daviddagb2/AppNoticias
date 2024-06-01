package com.gonzalez.blanchard.newsapp.data.datasource.local.entities.mappers

import com.gonzalez.blanchard.newsapp.data.datasource.local.entities.NewsEntity
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem

fun NewsItem.toDatabase() = NewsEntity(
    id = id,
    title = title,
    description = summary,
    url = url,
    content = content,
    imageUrl = imageUrl
)
