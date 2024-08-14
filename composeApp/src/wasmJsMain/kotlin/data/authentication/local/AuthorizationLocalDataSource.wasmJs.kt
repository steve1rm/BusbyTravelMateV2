package data.authentication.local

import domain.authentication.models.TokenAuthorizationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual class AuthorizationLocalDataSource {
    actual suspend fun get(): TokenAuthorizationModel? {
        withContext(Dispatchers.Unconfined) {

        }
        TODO("Not yet implemented")
    }

    actual suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?) {
    }
}