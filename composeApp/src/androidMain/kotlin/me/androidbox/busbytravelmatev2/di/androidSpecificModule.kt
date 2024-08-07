package me.androidbox.busbytravelmatev2.di

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val androidSpecificModule = module {
   single<Settings> {
      val encryptedSharedPreferences = EncryptedSharedPreferences(
         androidApplication(),
         "secret_shared_prefs",
         MasterKey(androidApplication())
      )

      SharedPreferencesSettings(encryptedSharedPreferences)
   }
}
