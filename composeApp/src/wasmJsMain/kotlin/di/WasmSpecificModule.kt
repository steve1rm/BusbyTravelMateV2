package di

import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import data.authentication.local.AuthorizationLocalDataSource
import data.authentication.local.imp.AuthorizationLocalDataSourceImp
import kotlinx.browser.window
import org.koin.dsl.module
import presentation.designsystem.components.ShowMessageManager
import presentation.designsystem.components.ShowMessageManagerImp

val wasmSpecificModule = module {

    single<Settings> {
        StorageSettings(window.localStorage)
    }

    factory<AuthorizationLocalDataSource> {
        AuthorizationLocalDataSourceImp(get<Settings>())
    }

    factory<ShowMessageManager> {
        ShowMessageManagerImp()
    }
}