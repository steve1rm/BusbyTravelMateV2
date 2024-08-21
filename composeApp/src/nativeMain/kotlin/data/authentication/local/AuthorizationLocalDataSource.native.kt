package data.authentication.local

import domain.authentication.models.TokenAuthorizationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class AuthorizationLocalDataSource {

    /** TODO Maybe add this to the domain 😆 ctrl + alt + ; */
    companion object {
        private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"
    }


    suspend fun get(): TokenAuthorizationModel? {
        withContext(Dispatchers.IO) {

        }
        TODO("Not yet implemented")
    }

    suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
        withContext(Dispatchers.IO) {

        }
    }
}