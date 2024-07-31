package data.di

import data.authentication.AuthenticationRepositoryImp
import data.remote.UserLoginRegisterRemoteDataSource
import data.remote.imp.UserLoginRegisterRemoteDataSourceImp
import domain.authentication.AuthenticationRepository
import org.koin.dsl.module

val dataModule = module {

    factory<UserLoginRegisterRemoteDataSource> {
        UserLoginRegisterRemoteDataSourceImp()
    }

    factory<AuthenticationRepository> {
        AuthenticationRepositoryImp(get<UserLoginRegisterRemoteDataSource>())
    }
}