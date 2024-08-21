package presentation.di


import domain.authentication.UserEmailPasswordValidator
import domain.authentication.usecases.LoginUserWithPasswordUseCase
import domain.authentication.usecases.RegisterUserUseCase
import org.koin.dsl.module
import presentation.authentication.login.LoginViewModel
import presentation.authentication.signup.RegisterViewModel

val presentationModule = module {
/*
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
*/

    single {
        LoginViewModel(
         //   get<UserEmailPasswordValidator>(),
            get<LoginUserWithPasswordUseCase>()
        )
    }

    single {
        RegisterViewModel(
            get<UserEmailPasswordValidator>(),
            get<RegisterUserUseCase>()
        )
    }
}