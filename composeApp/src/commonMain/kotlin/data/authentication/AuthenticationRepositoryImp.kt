package data.authentication

import domain.authentication.AuthenticationRepository
import domain.utils.CheckResult
import domain.utils.DataError

class AuthenticationRepositoryImp(
 //   private val userLoginRegisterRemoteDataSource: UserLoginRegisterRemoteDataSource
) : AuthenticationRepository {


    override suspend fun loginUser(email: String, password: String): CheckResult<Nothing, DataError.Network, String> {
      //  return userLoginRegisterRemoteDataSource.loginUser(email, password)
        TODO()
    }

    override suspend fun registerUser(email: String, password: String): CheckResult<String, DataError.Network, String> {
      //  return userLoginRegisterRemoteDataSource.registerUser(email, password)
        TODO()
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
