package data.di

import data.authentication.AuthenticationRepositoryImp
import data.network_client.HttpKtorClient
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.authentication.remote.imp.UserLoginRegisterRemoteDataSourceImp
import domain.authentication.AuthenticationRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.dsl.module

val dataModule = module {

    factory<AuthenticationRepository> {
        AuthenticationRepositoryImp(get<UserLoginRegisterRemoteDataSource>())
    }

    single<HttpClient> {
        HttpKtorClient(get<HttpClientEngine>()).build()
    }

    factory<UserLoginRegisterRemoteDataSource> {
        UserLoginRegisterRemoteDataSourceImp(get<HttpClient>())
    }
}