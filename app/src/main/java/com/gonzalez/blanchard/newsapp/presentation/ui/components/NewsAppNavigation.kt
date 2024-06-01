package com.gonzalez.blanchard.newsapp.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem
import com.gonzalez.blanchard.newsapp.presentation.ui.screens.NewsDetailScreen
import com.gonzalez.blanchard.newsapp.presentation.ui.screens.NewsListScreen

val sampleNewsList = listOf(
    NewsItem(
        id = "1",
        title = "New Advances in AI Technology",
        summary = "AI is transforming multiple industries with new advancements.",
        content = "Detailed content about AI advancements...",
        imageUrl = "https://example.com/image1.jpg",
        url = ""
    ),
    NewsItem(
        id = "2",
        title = "Global Economic Shifts",
        summary = "Recent shifts in global economy have experts talking.",
        content = "Detailed content about economic shifts...",
        imageUrl = "https://example.com/image2.jpg",
        url = ""
    ),
    NewsItem(
        id = "3",
        title = "Climate Change and Future Policies",
        summary = "Policymakers are taking action against climate change.",
        content = "Detailed content about climate change...",
        imageUrl = "https://example.com/image3.jpg",
        url = ""
    )
)

@Composable
fun NewsAppNavigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "newsList"){
        composable("newsList"){
            NewsListScreen(
                onNewsSelected = { news ->
                    navController.navigate("newsDetail/${news.id}")
                } )
        }

        composable("newsDetail/{newsId}"){backStackEntry ->
            val newsId = backStackEntry.arguments?.getString("newsId")
            val newsItem = sampleNewsList.find {
                it.id == newsId
            }
            if (newsItem != null) {
                NewsDetailScreen(newsItem = newsItem, onBack = {
                    navController.navigateUp()
                })
            }
        }
    }

}