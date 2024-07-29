package data.preference

import domain.preferences.PreferenceRepository.Companion.DATA_STORE_FILE_NAME

actual class CreateDateStorePath {
    actual val path: String
        get() {
            val directory = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null
            )

            return directory.path + "/$DATA_STORE_FILE_NAME"
        }
}