package domain.authentication.usecases.imp

import data.authentication.dto.AuthenticationInfoDto
import data.dto.ErrorResponseDto
import domain.authentication.AuthenticationRepository
import domain.authentication.models.AuthenticationUserModel
import domain.authentication.usecases.LoginUserUseCase
import domain.utils.CheckResult
import domain.utils.DataError

class LoginUserUseCaseImp(private val authenticationRepository: AuthenticationRepository) :
    LoginUserUseCase {

    override suspend fun execute(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        return authenticationRepository.loginUser(authenticationUserModel)
    }
}