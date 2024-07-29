package domain.preferences

interface PreferenceRepository {
    companion object {
        const val DATA_STORE_FILE_NAME = "prefs.preferences_pb"
    }

    suspend fun savePreference(key: String, value: String)
    suspend fun retrievePreference(key: String): String?
}