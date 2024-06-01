package com.gonzalez.blanchard.newsapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsItemView(
    news: NewsItem,
    onItemClick: (NewsItem) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        onClick = { onItemClick(news) }
    ){

        Column(
            modifier = Modifier.padding(16.dp)
        ){
            Text(text = news.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = news.imageUrl,
                contentDescription = news.title,
                modifier = Modifier.fillMaxWidth().height(300.dp)
            )
            Text(
                text = news.summary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewNewsItemView(){

    val sampleNewsItem = NewsItem(
        id = "1",
        title = "Exploring Jetpack Compose",
        summary = "Jetpack Compose simplifies UI development on Android with declarative programming.",
        content = "Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
        imageUrl = "https://example.com/sample-image.jpg",
        url = "https://www.espine.in/blog/wp-content/uploads/2022/08/software-developer.jpg"
    )

    NewsItemView(
        news= sampleNewsItem,
        onItemClick={}
    )
}