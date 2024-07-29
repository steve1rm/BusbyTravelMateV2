package data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import data.authentication.AuthenticationRepositoryImp
import data.preference.CreateDateStorePath
import data.preference.PreferenceRepositoryImp
import data.preference.local.PreferenceLocalDataSource
import data.preference.local.imp.PreferenceLocalDataSourceImp
import domain.authentication.AuthenticationRepository
import domain.preferences.PreferenceRepository
import okio.Path.Companion.toPath
import org.koin.dsl.module

val dataModule = module {

    factory<AuthenticationRepository> {
        AuthenticationRepositoryImp()
    }

    single {
        val pathProvider = get<CreateDateStorePath>()

        val path = pathProvider.path

        PreferenceDataStoreFactory.createWithPath(
            produceFile = {
                path.toPath()
            }
        )
    }

    factory<PreferenceLocalDataSource> {
        PreferenceLocalDataSourceImp(get<DataStore<Preferences>>())
    }

    factory<PreferenceRepository> {
        PreferenceRepositoryImp(get<PreferenceLocalDataSource>())
    }
}