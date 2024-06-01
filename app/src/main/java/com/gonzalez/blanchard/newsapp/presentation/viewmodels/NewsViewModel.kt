package com.gonzalez.blanchard.newsapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.newsapp.domain.model.NewsItem
import com.gonzalez.blanchard.newsapp.domain.usecase.GetNewsFromApiUseCase
import com.gonzalez.blanchard.newsapp.presentation.states.UiState
import com.gonzalez.blanchard.newsapp.utils.parseException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsFromApiUseCase: GetNewsFromApiUseCase
): ViewModel()
{
    var newsData = MutableLiveData<List<NewsItem>>()

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    init {
        updateUiState(UiState.StartedUI)
    }

    fun retrieveNews(){
        updateUiState(UiState.InProgress)
        viewModelScope.launch {
            try {

                getNewsFromApiUseCase().collect{ result ->
                    when(result){
                        is GetNewsFromApiUseCase.Result.Complete -> {
                            newsData.value = result.newsList
                            updateUiState(UiState.Complete)
                        }
                        is GetNewsFromApiUseCase.Result.Error -> {
                            updateUiState(UiState.Error(result.exception))
                        }
                    }
                }
            }catch (e: Exception){
                updateUiState(UiState.Error(e.parseException()))
            }
        }
    }

    private fun updateUiState(newState: UiState) {
        _uiState.value = newState
    }

}