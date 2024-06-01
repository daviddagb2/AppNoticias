package com.gonzalez.blanchard.newsapp.domain.model.mappers

import com.gonzalez.blanchard.newsapp.data.datasource.remote.model.NewsResponseDto
import com.gonzalez.blanchard.newsapp.domain.model.NewsResponseItem


fun NewsResponseDto.toDomain() = NewsResponseItem(
    status = status,
    totalResults = totalResults,
    articles = articles.map { it.toDomain() }
)