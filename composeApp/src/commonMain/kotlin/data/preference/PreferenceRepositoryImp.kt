package data.preference

import data.preference.local.PreferenceLocalDataSource
import domain.preferences.PreferenceRepository

class PreferenceRepositoryImp(private val preferenceLocalDataSource: PreferenceLocalDataSource) : PreferenceRepository {
    override suspend fun savePreference(key: String, value: String) {
        preferenceLocalDataSource.savePreference(key, value)
    }

    override suspend fun retrievePreference(key: String): String? {
        return preferenceLocalDataSource.retrievePreference(key)
    }
}