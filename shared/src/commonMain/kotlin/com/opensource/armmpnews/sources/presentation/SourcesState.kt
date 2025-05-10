package com.opensource.armmpnews.sources.presentation

import com.opensource.armmpnews.sources.application.Source

data class SourcesState(
    val sources: List<Source>,
    val loading: Boolean = false,
    val error: String? = null
)
