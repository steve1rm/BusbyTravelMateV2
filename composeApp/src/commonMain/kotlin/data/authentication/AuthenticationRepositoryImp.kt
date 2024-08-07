package data.authentication

import data.authentication.dto.AuthenticationInfoDto
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.dto.ErrorResponseDto
import domain.authentication.AuthenticationRepository
import domain.authentication.models.AuthenticationUserModel
import domain.authentication.models.TokenAuthorizationModel
import domain.utils.CheckResult
import domain.utils.DataError

class AuthenticationRepositoryImp(
   private val userLoginRegisterRemoteDataSource: UserLoginRegisterRemoteDataSource
) : AuthenticationRepository {

    override suspend fun loginUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        return userLoginRegisterRemoteDataSource.loginUser(authenticationUserModel)
    }

    override suspend fun registerUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        return userLoginRegisterRemoteDataSource.registerUser(authenticationUserModel)
    }

    override suspend fun logout(): CheckResult<Unit, Unit, Unit> {
       // return userLoginRegisterRemoteDataSource.logout()
        TODO()
    }

    override suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit> {
      //  return userLoginRegisterRemoteDataSource.isLoggedIn()
        TODO()
    }

    override suspend fun fetchTokenAuthorization(): TokenAuthorizationModel? {
        TODO("Not yet implemented")
    }

    override suspend fun setTokenAuthorization(tokenAuthorizationModel: TokenAuthorizationModel) {
        TODO("Not yet implemented")
    }
}
