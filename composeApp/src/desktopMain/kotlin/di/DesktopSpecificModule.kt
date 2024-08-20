package di

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import data.authentication.local.AuthorizationLocalDataSource
import org.koin.dsl.module
import java.util.prefs.Preferences

val desktopSpecificModule = module {
    single<Settings> {
        val preferences = Preferences.userRoot()

        PreferencesSettings(preferences)
    }

    factory {
        AuthorizationLocalDataSource(get<Settings>())
    }
}