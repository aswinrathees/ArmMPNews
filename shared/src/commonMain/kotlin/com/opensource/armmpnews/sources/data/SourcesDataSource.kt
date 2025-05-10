package com.opensource.armmpnews.sources.data

import opensource.armmpnews.db.ARMMPNewsDB

class SourcesDataSource(private val db: ARMMPNewsDB) {

    fun getAllSources(): List<SourcesRaw> = db.armMPNewsDBQueries.selectAllSources(::mapSource).executeAsList()

    fun clearSources() = db.armMPNewsDBQueries.removeAllSources()

    internal fun createSources(sources: List<SourcesRaw>) {
        db.armMPNewsDBQueries.transaction {
            sources.forEach { source ->
                insertSource(source)
            }
        }
    }

    private fun mapSource(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String
    ): SourcesRaw = SourcesRaw(id, name, desc, language, country)

    private fun insertSource(source: SourcesRaw) {
        db.armMPNewsDBQueries.insertSource(source.id, source.name, source.desc, source.language, source.country)
    }
}