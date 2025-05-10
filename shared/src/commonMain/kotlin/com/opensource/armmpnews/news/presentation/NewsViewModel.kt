package com.opensource.armmpnews.news.presentation

import com.opensource.armmpnews.BaseViewModel
import com.opensource.armmpnews.news.application.NewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val useCase: NewsUseCase
): BaseViewModel() {

    private val _articleState: MutableStateFlow<NewsState> = MutableStateFlow(NewsState(loading = true))

    val newsState: StateFlow<NewsState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articleState.emit(NewsState(loading = true, articles = _articleState.value.articles))
            val articles = useCase.getArticles(forceFetch)
            _articleState.emit(NewsState(loading = false, articles = articles))
        }
    }
}