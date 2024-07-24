package domain.authentication.usecases

import domain.utils.CheckResult
import domain.utils.DataError

fun interface LoginUserWithEmailAndPasswordUseCase {
    suspend fun execute(email: String, password: String): CheckResult<Nothing, DataError.Network, String>
}