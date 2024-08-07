package data.authentication.local

import domain.authentication.models.TokenAuthorizationModel

interface AuthorizationLocalDataSource {
    suspend fun get(): TokenAuthorizationModel?
    suspend fun set(authorizationInfo: TokenAuthorizationModel?)
}