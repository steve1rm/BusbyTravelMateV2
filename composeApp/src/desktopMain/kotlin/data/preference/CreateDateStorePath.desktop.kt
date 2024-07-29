package data.preference

import domain.preferences.PreferenceRepository.Companion.DATA_STORE_FILE_NAME

actual class CreateDateStorePath {
    actual val path: String
        get() {
            return DATA_STORE_FILE_NAME
        }
}