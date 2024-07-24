package presentation.di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.authentication.login.LoginViewModel

val presentationModule = module {
    viewModelOf(::LoginViewModel)
}