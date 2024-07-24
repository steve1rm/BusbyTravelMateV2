package domain.authentication.usecases.imp

import domain.authentication.AuthenticationRepository
import domain.authentication.usecases.LoginUserWithEmailAndPasswordUseCase
import domain.utils.CheckResult
import domain.utils.DataError

class LoginUserWithEmailAndPasswordUseCaseImp(private val authenticationRepository: AuthenticationRepository) :
    LoginUserWithEmailAndPasswordUseCase {

    override suspend fun execute(email: String, password: String): CheckResult<Nothing, DataError.Network, String> {
        return authenticationRepository.loginUser(email, password)
    }
}