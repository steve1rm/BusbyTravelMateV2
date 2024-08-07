package data.authentication.local

import domain.authentication.models.TokenAuthorizationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

actual class AuthorizationLocalDataSource {

    /** TODO Maybe add this to the domain */
    companion object {
        private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"
    }


    actual suspend fun get(): TokenAuthorizationModel? {
        withContext(Dispatchers.IO) {

        }
        TODO("Not yet implemented")
    }

    actual suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
        withContext(Dispatchers.IO) {

        }
    }
}