package data.authentication.local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import domain.authentication.models.TokenAuthorizationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString

class AuthorizationLocalDataSource(private val settings: Settings) {

    /** TODO Maybe add this to the domain */
    companion object {
        private const val KEY_AUTH_INFO = "key_auth_tokens"
    }

    suspend fun get(): TokenAuthorizationModel? {
        val tokenAuthorizationModel = withContext(Dispatchers.IO) {
            val tokens = settings.get<String>(KEY_AUTH_INFO) ?: ""

            if(tokens.isNotEmpty()) {
                decodeFromString<TokenAuthorizationModel>(tokens)
            }
            else {
                null
            }
        }

        return tokenAuthorizationModel
    }

    suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
        if(tokenAuthorizationModel == null) {
            withContext(Dispatchers.IO) {
                settings.remove(KEY_AUTH_INFO)
            }
        }
        else {
            withContext(Dispatchers.IO) {
                val tokenAuthorizationModel = Json.encodeToString(tokenAuthorizationModel)

                settings[KEY_AUTH_INFO] = tokenAuthorizationModel
            }
        }
    }
}