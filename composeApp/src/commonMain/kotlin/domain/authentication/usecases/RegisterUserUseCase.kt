package domain.authentication.usecases

import data.authentication.dto.AuthenticationInfoDto
import data.dto.ErrorResponseDto
import domain.authentication.models.AuthenticationUserModel
import domain.utils.CheckResult
import domain.utils.DataError

fun interface RegisterUserUseCase {
    suspend fun execute(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto>
}