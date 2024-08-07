package data.authentication.remote

import data.authentication.dto.AuthenticationInfoDto
import data.dto.ErrorResponseDto
import domain.authentication.models.AuthenticationUserModel
import domain.utils.CheckResult
import domain.utils.DataError

interface UserLoginRegisterRemoteDataSource {
    suspend fun loginUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto>
    suspend fun registerUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto>
    suspend fun logout(): CheckResult<Unit, Unit, Unit>
    suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit>
}