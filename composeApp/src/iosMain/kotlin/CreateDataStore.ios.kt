import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.DATA_STORE_FILE_NAME

fun createDataStore(): DataStore<Preferences> {
    data.createDataStore {
        val directory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )

        requireNotNull(directory).path + "/$DATA_STORE_FILE_NAME"
    }
}