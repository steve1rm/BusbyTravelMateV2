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

actual class AuthorizationLocalDataSource(private val settings: Settings) {

    /** TODO Maybe add this to the domain */
    companion object {
        private const val KEY_AUTH_TOKENS = "key_auth_token_id"
    }

    actual suspend fun get(): TokenAuthorizationModel? {
        return withContext(Dispatchers.IO) {
            val tokens = settings[KEY_AUTH_TOKENS, ""]

            if(tokens.isNotEmpty()) {
                decodeFromString<TokenAuthorizationModel>(tokens)
            }
            else {
                null
            }
        }
    }

    actual suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
        if(tokenAuthorizationModel == null) {
            /** Remove the keys and values for the tokens
             * i.e. logging out user we should clear in case different user logs in*/
            withContext(Dispatchers.IO) {
                settings.remove(KEY_AUTH_TOKENS)
            }
        }
        else {
            withContext(Dispatchers.IO) {
                val tokens = Json.encodeToString(tokenAuthorizationModel)
                settings[KEY_AUTH_TOKENS] = tokens
            }
        }
    }
}