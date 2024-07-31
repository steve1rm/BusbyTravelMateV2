package data.authentication

import data.authentication.dto.AuthenticationInfoDto
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.dto.ErrorResponseDto
import domain.authentication.AuthenticationRepository
import domain.authentication.models.RegisterUserModel
import domain.utils.CheckResult
import domain.utils.DataError

class AuthenticationRepositoryImp(
   private val userLoginRegisterRemoteDataSource: UserLoginRegisterRemoteDataSource
) : AuthenticationRepository {


    override suspend fun loginUser(email: String, password: String): CheckResult<Nothing, DataError.Network, String> {
      //  return userLoginRegisterRemoteDataSource.loginUser(email, password)
        TODO()
    }

    override suspend fun registerUser(registerUserModel: RegisterUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
      return userLoginRegisterRemoteDataSource.registerUser(registerUserModel)
    }

    override suspend fun logout(): CheckResult<Unit, Unit, Unit> {
       // return userLoginRegisterRemoteDataSource.logout()
        TODO()
    }

    override suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit> {
      //  return userLoginRegisterRemoteDataSource.isLoggedIn()
        TODO()
    }
}
