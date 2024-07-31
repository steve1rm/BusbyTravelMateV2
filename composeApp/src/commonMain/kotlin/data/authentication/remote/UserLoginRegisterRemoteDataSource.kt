package data.authentication.remote

import data.authentication.dto.AuthenticationInfoDto
import data.dto.ErrorResponseDto
import domain.authentication.models.RegisterUserModel
import domain.utils.CheckResult
import domain.utils.DataError

interface UserLoginRegisterRemoteDataSource {
    suspend fun loginUser(email: String, password: String): CheckResult<String, Unit, Unit>
    suspend fun registerUser(registerUserModel: RegisterUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto>
    suspend fun logout(): CheckResult<Unit, Unit, Unit>
    suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit>
}