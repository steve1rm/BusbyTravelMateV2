package di

import data.preference.CreateDateStorePath
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val platformSpecific = module {
    single {
        CreateDateStorePath(androidContext())
    }
}