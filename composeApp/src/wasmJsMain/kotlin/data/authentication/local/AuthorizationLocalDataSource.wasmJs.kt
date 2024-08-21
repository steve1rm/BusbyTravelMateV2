package data.authentication.local

import domain.authentication.models.TokenAuthorizationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthorizationLocalDataSource {
    suspend fun get(): TokenAuthorizationModel? {
        withContext(Dispatchers.IO) {

        }
    }

    suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
    }
}