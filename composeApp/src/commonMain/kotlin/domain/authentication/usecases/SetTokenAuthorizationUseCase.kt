package domain.authentication.usecases

import domain.authentication.models.TokenAuthorizationModel

fun interface SetTokenAuthorizationUseCase {
    suspend fun execute(tokenAuthorizationModel: TokenAuthorizationModel)
}