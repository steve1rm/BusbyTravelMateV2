package domain.authentication.usecases

import domain.authentication.models.TokenAuthorizationModel

fun interface GetTokenAuthorizationUseCase {
    suspend fun execute(): TokenAuthorizationModel?
}