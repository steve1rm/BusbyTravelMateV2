package data.preference

import android.content.Context
import domain.preferences.PreferenceRepository.Companion.DATA_STORE_FILE_NAME

actual class CreateDateStorePath(private val context: Context) {
    actual val path: String
        get() {
            return context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
        }
}