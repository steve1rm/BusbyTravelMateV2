package data.authentication.local

import domain.authentication.models.TokenAuthorizationModel

expect class AuthorizationLocalDataSource {
    suspend fun get(): TokenAuthorizationModel?
    suspend fun set(tokenAuthorizationModel: TokenAuthorizationModel?)
}