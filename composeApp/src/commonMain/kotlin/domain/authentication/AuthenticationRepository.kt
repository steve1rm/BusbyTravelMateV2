package domain.authentication

import domain.utils.CheckResult
import domain.utils.DataError

interface AuthenticationRepository {
    suspend fun loginUser(email: String, password: String): CheckResult<Nothing, DataError.Network, String>
    suspend fun registerUser(email: String, password: String): CheckResult<String, DataError.Network, String>
    suspend fun logout(): CheckResult<Unit, Unit, Unit>
    suspend fun isLoggedIn(): CheckResult<Boolean, Unit, Unit>
}
