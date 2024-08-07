package data.di

import data.authentication.AuthenticationRepositoryImp
import data.authentication.local.AuthorizationLocalDataSource
import data.authentication.remote.UserLoginRegisterRemoteDataSource
import data.authentication.remote.imp.UserLoginRegisterRemoteDataSourceImp
import data.network_client.HttpKtorClient
import domain.authentication.AuthenticationRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.dsl.module

val dataModule = module {

    factory<AuthenticationRepository> {
        AuthenticationRepositoryImp(get<UserLoginRegisterRemoteDataSource>(), get<AuthorizationLocalDataSource>())
    }

    single<HttpClient> {
        HttpKtorClient(get<HttpClientEngine>()).build()
    }

    factory<UserLoginRegisterRemoteDataSource> {
        UserLoginRegisterRemoteDataSourceImp(get<HttpClient>())
    }
}