package domain.di

import com.chrynan.validator.EmailValidator
import domain.authentication.AuthenticationRepository
import domain.authentication.PatternValidator
import domain.authentication.UserEmailPasswordValidator
import domain.authentication.imp.EmailPatternValidatorImp
import domain.authentication.imp.UserEmailPasswordValidatorImp
import domain.authentication.usecases.LoginUserWithEmailAndPasswordUseCase
import domain.authentication.usecases.imp.LoginUserWithEmailAndPasswordUseCaseImp
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    factory<UserEmailPasswordValidator> {
        UserEmailPasswordValidatorImp(get<PatternValidator>())
    }

    factoryOf(::EmailValidator)

    factory<PatternValidator> {
        EmailPatternValidatorImp(get<EmailValidator>())
    }

    factory<LoginUserWithEmailAndPasswordUseCase> {
        LoginUserWithEmailAndPasswordUseCaseImp(get<AuthenticationRepository>())
    }
}