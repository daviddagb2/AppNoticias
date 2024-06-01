package com.gonzalez.blanchard.newsapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(
    newsItem: NewsItem,
    onBack: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Detalle de Noticia")
            },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ){padding ->

        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .padding(padding)
        ){
            Text(text = newsItem.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = newsItem.content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsDetailScreen(){

    val sampleNewsItem = NewsItem(
        id = "1",
        title = "Exploring Jetpack Compose",
        summary = "Jetpack Compose simplifies UI development on Android with declarative programming.",
        content = "Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
        imageUrl = "https://example.com/sample-image.jpg",
        url = ""
    )

    NewsDetailScreen(
        sampleNewsItem,
        {}
    )
}