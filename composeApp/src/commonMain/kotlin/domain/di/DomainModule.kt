package domain.di

import domain.authentication.AuthenticationRepository
import domain.authentication.PatternValidator
import domain.authentication.UserEmailPasswordValidator
import domain.authentication.imp.EmailPatternValidatorImp
import domain.authentication.imp.UserEmailPasswordValidatorImp
import domain.authentication.usecases.LoginUserWithEmailAndPasswordUseCase
import domain.authentication.usecases.imp.LoginUserWithEmailAndPasswordUseCaseImp
import domain.preferences.PreferenceRepository
import domain.preferences.usecases.RetrievePreferenceUseCase
import domain.preferences.usecases.SavePreferenceUseCase
import domain.preferences.usecases.imp.RetrievePreferenceUseCaesImp
import domain.preferences.usecases.imp.SavePreferenceUseCaesImp
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

    factory<LoginUserWithEmailAndPasswordUseCase> {
        LoginUserWithEmailAndPasswordUseCaseImp(get<AuthenticationRepository>())
    }

    factory<RetrievePreferenceUseCase> {
        RetrievePreferenceUseCaesImp(get<PreferenceRepository>())
    }

    factory<SavePreferenceUseCase> {
        SavePreferenceUseCaesImp(get<PreferenceRepository>())
    }
}