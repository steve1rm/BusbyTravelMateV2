package domain.authentication.usecases.imp

import data.authentication.dto.AuthenticationInfoDto
import data.dto.ErrorResponseDto
import domain.authentication.AuthenticationRepository
import domain.authentication.models.RegisterUserModel
import domain.authentication.usecases.RegisterUserUseCase
import domain.utils.CheckResult
import domain.utils.DataError

class RegisterUserUseCaseImp(private val authenticationRepository: AuthenticationRepository) :
    RegisterUserUseCase {

    override suspend fun execute(registerUserModel: RegisterUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        return authenticationRepository.registerUser(registerUserModel)
    }
}