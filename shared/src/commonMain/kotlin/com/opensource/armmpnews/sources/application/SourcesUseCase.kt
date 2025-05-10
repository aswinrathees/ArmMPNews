package com.opensource.armmpnews.sources.application

import com.opensource.armmpnews.sources.data.SourcesRaw
import com.opensource.armmpnews.sources.data.SourcesRepository

class SourcesUseCase(private val repository: SourcesRepository) {

    suspend fun getSources(): List<Source> {
        val sourcesRaw = repository.getAllSources()
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourcesRaw>): List<Source> = sourcesRaw.map {
        Source(it.id, it.name, it.desc, mapOrigin(it))
    }

    private fun mapOrigin(raw: SourcesRaw) = "${raw.language.uppercase()} - ${raw.country.uppercase()}"
}