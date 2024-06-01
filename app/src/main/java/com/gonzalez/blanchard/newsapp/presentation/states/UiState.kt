package com.gonzalez.blanchard.newsapp.presentation.states

import com.gonzalez.blanchard.newsapp.utils.BusinessException

sealed class UiState {
    object StartedUI : UiState()
    object InProgress : UiState()
    object Complete : UiState()
    data class Error(val exception: BusinessException) : UiState()
}