package di

import com.russhwolf.settings.Settings
import data.authentication.local.AuthorizationLocalDataSource
import data.authentication.local.imp.AuthorizationLocalDataSourceImp
import org.koin.dsl.module

val wasmSpecificModule = module {

    factory<AuthorizationLocalDataSource> {
        AuthorizationLocalDataSourceImp(get<Settings>())
    }
}