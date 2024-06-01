package com.gonzalez.blanchard.newsapp.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem
import com.gonzalez.blanchard.newsapp.presentation.states.UiState
import com.gonzalez.blanchard.newsapp.presentation.ui.components.InProgressUIComponent
import com.gonzalez.blanchard.newsapp.presentation.ui.components.NewsItemView
import com.gonzalez.blanchard.newsapp.presentation.ui.components.NewsListComponent
import com.gonzalez.blanchard.newsapp.presentation.ui.components.StartedUIComponent
import com.gonzalez.blanchard.newsapp.presentation.viewmodels.NewsViewModel
import com.gonzalez.blanchard.newsapp.utils.ErrorType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    onNewsSelected: (NewsItem) -> Unit,
    newsVM: NewsViewModel = hiltViewModel(),
){
    val uiState: UiState? by newsVM.uiState.observeAsState()
    val newsList: List<NewsItem>? by newsVM.newsData.observeAsState()

    Scaffold (
        topBar = { TopAppBar(title = { Text("Ultimas Noticias") }) }
    ){ padding ->
        when(uiState){
            UiState.StartedUI -> {
                StartedUIComponent {
                    newsVM.retrieveNews()
                }
            }
            UiState.InProgress -> {
                InProgressUIComponent()
            }

            UiState.Complete ->{
                NewsListComponent(
                    list = newsList ?: emptyList(),
                    onNewsSelected = onNewsSelected
                )
            }
            
            is UiState.Error -> {
                val error = (uiState as UiState.Error)

                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ){
                    when(error.exception.errorType){
                        ErrorType.CONNECTIVITY_ERROR -> {
                            Text(text = "No hay conexión")
                        }
                        else -> {
                            Text(text = "Ocurrio un error Intetelo de nuevo")
                        }
                    }
                    Button(onClick = {
                        newsVM.retrieveNews()
                    }) {
                        Text(text = "Cargar Noticias")
                    }
                }
            }

            else -> {
                Text(text = "Opción inválida")
            }
        }

    }
}

