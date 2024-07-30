package data.remote

import domain.utils.CheckResult

interface UserLoginRegisterRemoteDataSource {
    suspend fun loginUser(email: String, password: String): CheckResult<String, Unit, Unit>
    suspend fun registerUser(email: String, password: String): CheckResult<String, Unit, Unit>
    suspend fun logout(): CheckResult<Unit, Unit, Unit>
    suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit>
}