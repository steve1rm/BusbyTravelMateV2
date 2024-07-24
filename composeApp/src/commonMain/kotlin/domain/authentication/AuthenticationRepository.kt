package domain.authentication

import domain.utils.CheckResult
import domain.utils.DataError

interface AuthenticationRepository {
    suspend fun register(email: String, password: String): CheckResult<Nothing, DataError.Network, String>
    suspend fun login(email: String, password: String): CheckResult<Nothing, DataError.Network, String>
}