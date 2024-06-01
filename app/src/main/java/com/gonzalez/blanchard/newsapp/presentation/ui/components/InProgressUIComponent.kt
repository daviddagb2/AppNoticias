package com.gonzalez.blanchard.newsapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InProgressUIComponent(){
    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Obteniendo Información", style = MaterialTheme.typography.headlineSmall)
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInProgressUIComponent(){
    InProgressUIComponent()
}