package com.gonzalez.blanchard.newsapp.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StartedUIComponent(
    onClick: () -> Unit
){
    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(20.dp)
            .fillMaxSize()
    ){
        Text(text = "App de Noticias", style = MaterialTheme.typography.titleLarge)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(onClick = onClick) {
                Text(text = "Cargar Noticias")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartedUIComponent(){
    StartedUIComponent(onClick = {})
}