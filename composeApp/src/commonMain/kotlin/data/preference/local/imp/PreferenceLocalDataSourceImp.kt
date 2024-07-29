package data.preference.local.imp

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import data.preference.local.PreferenceLocalDataSource
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class PreferenceLocalDataSourceImp(private val dataStore: DataStore<Preferences>) : PreferenceLocalDataSource {

    override suspend fun savePreference(key: String, value: String) {
        dataStore.edit { preference ->
            val key = stringPreferencesKey(key)
            preference[key] = value
        }
    }

    override suspend fun retrievePreference(key: String): String? {
        val key = stringPreferencesKey(key)

        val value = dataStore.data.map { preferences ->
            preferences[key]
        }.firstOrNull()

        return value
    }
}