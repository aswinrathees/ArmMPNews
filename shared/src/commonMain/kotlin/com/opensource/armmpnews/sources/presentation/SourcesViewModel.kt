package com.opensource.armmpnews.sources.presentation

import com.opensource.armmpnews.BaseViewModel
import com.opensource.armmpnews.sources.application.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(private val useCase: SourcesUseCase) : BaseViewModel() {

    private val _sourcesState = MutableStateFlow(SourcesState(listOf(), true, null))
    val sourcesState = _sourcesState

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            _sourcesState.emit(SourcesState(listOf(), true, null))
            val sourcesState = useCase.getSources()
            _sourcesState.emit(SourcesState(sourcesState, false, null))
        }
    }
}