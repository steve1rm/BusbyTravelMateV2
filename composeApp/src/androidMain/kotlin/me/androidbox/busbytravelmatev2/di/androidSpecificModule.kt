package me.androidbox.busbytravelmatev2.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import data.authentication.local.AuthorizationLocalDataSource
import data.authentication.local.imp.AuthorizationLocalDataSourceImp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import presentation.designsystem.components.ShowMessageManager
import presentation.designsystem.components.ShowMessageManagerImp

val androidSpecificModule = module {
   single<Settings> {
      val encryptedSharedPreferences = EncryptedSharedPreferences(
         androidApplication(),
         "secret_shared_prefs",
         MasterKey(androidApplication())
      )

      SharedPreferencesSettings(encryptedSharedPreferences)
   }

   factory<AuthorizationLocalDataSource> {
      AuthorizationLocalDataSourceImp(get<Settings>())
   }

   factory<ShowMessageManager> {
      ShowMessageManagerImp(context = androidApplication())
   }
}
