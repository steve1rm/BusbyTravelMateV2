package data.preference.local

interface PreferenceLocalDataSource {
    suspend fun savePreference(key: String, value: String)
    suspend fun retrievePreference(key: String): String?
}