package domain.authentication.usecases.imp

import domain.authentication.AuthenticationRepository
import domain.authentication.models.TokenAuthorizationModel
import domain.authentication.usecases.GetTokenAuthorizationUseCase

class GetTokenAuthorizationUseCaseImp(
    private val authenticationRepository: AuthenticationRepository
) : GetTokenAuthorizationUseCase {
    override suspend fun execute(): TokenAuthorizationModel? {
        return authenticationRepository.fetchTokenAuthorization()
    }
}