package di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import data.authentication.local.AuthorizationLocalDataSource
import data.authentication.local.imp.AuthorizationLocalDataSourceImp
import org.koin.dsl.module
import presentation.designsystem.components.ShowMessageManager
import presentation.designsystem.components.ShowMessageManagerImp
import java.util.prefs.Preferences

val desktopSpecificModule = module {
    single<Settings> {
        val preferences = Preferences.userRoot()

        PreferencesSettings(preferences)
    }

    factory<AuthorizationLocalDataSource> {
        AuthorizationLocalDataSourceImp(get<Settings>())
    }

    factory<ShowMessageManager> {
        ShowMessageManagerImp()
    }
}