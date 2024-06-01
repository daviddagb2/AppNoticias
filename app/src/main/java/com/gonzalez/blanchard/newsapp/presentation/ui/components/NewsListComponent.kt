package com.gonzalez.blanchard.newsapp.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem

@Composable
fun NewsListComponent(
    list: List<NewsItem> = emptyList(),
    onNewsSelected: (NewsItem) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        item {
            Text(text = "App de Noticias", style = MaterialTheme.typography.titleLarge)
        }

        items(list){ news ->
            NewsItemView(
                news = news,
                onItemClick = onNewsSelected
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsListComponent(){
    NewsListComponent(
        list = emptyList(),
        onNewsSelected = {}
    )
}