package data.di

import data.authentication.AuthenticationRepositoryImp
import domain.authentication.AuthenticationRepository
import org.koin.dsl.module

val dataModule = module {

    factory<AuthenticationRepository> {
        AuthenticationRepositoryImp()
    }
}