package domain.di

import domain.authentication.AuthenticationRepository
import domain.authentication.PatternValidator
import domain.authentication.UserEmailPasswordValidator
import domain.authentication.imp.EmailPatternValidatorImp
import domain.authentication.imp.UserEmailPasswordValidatorImp
import domain.authentication.usecases.GetTokenAuthorizationUseCase
import domain.authentication.usecases.LoginUserUseCase
import domain.authentication.usecases.RegisterUserUseCase
import domain.authentication.usecases.SetTokenAuthorizationUseCase
import domain.authentication.usecases.imp.GetTokenAuthorizationUseCaseImp
import domain.authentication.usecases.imp.LoginUserUseCaseImp
import domain.authentication.usecases.imp.RegisterUserUseCaseImp
import domain.authentication.usecases.imp.SetTokenAuthorizationUseCaseImp
import domain.utils.EmailValidator
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

    factory<RegisterUserUseCase> {
        RegisterUserUseCaseImp(get<AuthenticationRepository>())
    }

    factory<LoginUserUseCase> {
        LoginUserUseCaseImp(get<AuthenticationRepository>())
    }

    factory<SetTokenAuthorizationUseCase> {
        SetTokenAuthorizationUseCaseImp(get<AuthenticationRepository>())
    }

    factory<GetTokenAuthorizationUseCase> {
        GetTokenAuthorizationUseCaseImp(get<AuthenticationRepository>())
    }
}