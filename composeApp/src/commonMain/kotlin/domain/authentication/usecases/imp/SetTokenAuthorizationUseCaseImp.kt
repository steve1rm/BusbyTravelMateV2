package domain.authentication.usecases.imp

import domain.authentication.AuthenticationRepository
import domain.authentication.models.TokenAuthorizationModel
import domain.authentication.usecases.SetTokenAuthorizationUseCase

class SetTokenAuthorizationUseCaseImp(
    private val authenticationRepository: AuthenticationRepository
) : SetTokenAuthorizationUseCase {
    override suspend fun execute(tokenAuthorizationModel: TokenAuthorizationModel) {
        return authenticationRepository.setTokenAuthorization(tokenAuthorizationModel)
    }
}