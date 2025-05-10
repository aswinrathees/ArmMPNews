package com.opensource.armmpnews.sources.data

class SourcesRepository(
    private val dataSource: SourcesDataSource,
    private val service: SourcesService
) {

    suspend fun getAllSources(): List<SourcesRaw> {
        val sourcesDB = dataSource.getAllSources()
        return when(sourcesDB.isEmpty()) {
            true -> {
                dataSource.clearSources()
                val fetchedSources = service.fetchSources()
                dataSource.createSources(fetchedSources)
                fetchedSources
            }
            false -> sourcesDB
        }
    }
}