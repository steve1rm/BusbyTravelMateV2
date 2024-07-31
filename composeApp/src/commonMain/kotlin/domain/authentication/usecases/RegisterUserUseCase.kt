package domain.authentication.usecases

import domain.authentication.models.RegisterUserModel
import domain.utils.CheckResult
import domain.utils.DataError

fun interface RegisterUserUseCase {
    suspend fun execute(registerUserModel: RegisterUserModel): CheckResult<String, DataError.Network, String>
}