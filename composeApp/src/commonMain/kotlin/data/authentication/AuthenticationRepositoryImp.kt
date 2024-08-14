package data.authentication

import data.authentication.dto.AuthenticationInfoDto
import data.authentication.local.AuthorizationLocalDataSource
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.dto.ErrorResponseDto
import domain.authentication.AuthenticationRepository
import domain.authentication.models.AuthenticationUserModel
import domain.authentication.models.TokenAuthorizationModel
import domain.utils.CheckResult
import domain.utils.DataError

class AuthenticationRepositoryImp(
    private val userLoginRegisterRemoteDataSource: UserLoginRegisterRemoteDataSource,
    private val authorizationLocalDataSource: AuthorizationLocalDataSource
) : AuthenticationRepository {

    override suspend fun loginUserWithIdpToken(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        val checkResult = userLoginRegisterRemoteDataSource.loginUserWithIdpToken(authenticationUserModel)

        when(checkResult) {
            is CheckResult.Failure -> {
                /** no-op no need to save any thing if there is a failure */
                /** TODO HANDLE THIS CASE AS THE SPINNER ON THE ACTION BUTTON DIDN'T STOP */
            }
            is CheckResult.Success -> {
                setTokenAuthorization(TokenAuthorizationModel(
                    tokenId = checkResult.data.idToken,
                    refreshToken = checkResult.data.refreshToken
                ))
            }
        }

        return checkResult
    }

    override suspend fun loginUserWithPassword(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        val checkResult = userLoginRegisterRemoteDataSource.loginUserWithPassword(authenticationUserModel)

        when(checkResult) {
            is CheckResult.Failure -> {
                /** no-op no need to save any thing if there is a failure */
            }
            is CheckResult.Success -> {
                setTokenAuthorization(TokenAuthorizationModel(
                    tokenId = checkResult.data.idToken,
                    refreshToken = checkResult.data.refreshToken
                ))
            }
        }

        return checkResult
    }


    override suspend fun registerUser(authenticationUserModel: AuthenticationUserModel): CheckResult<AuthenticationInfoDto, DataError.Network, ErrorResponseDto> {
        val checkResult = userLoginRegisterRemoteDataSource.registerUser(authenticationUserModel)

        when(checkResult) {
            is CheckResult.Failure -> {
                /** no-op no need to save any thing if there is a failure */
            }
            is CheckResult.Success -> {
                setTokenAuthorization(TokenAuthorizationModel(
                    tokenId = checkResult.data.idToken,
                    refreshToken = checkResult.data.refreshToken
                ))
            }
        }

        return checkResult
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
        return authorizationLocalDataSource.get()
    }

    override suspend fun setTokenAuthorization(tokenAuthorizationModel: TokenAuthorizationModel) {
        authorizationLocalDataSource.set(tokenAuthorizationModel)
    }
}
