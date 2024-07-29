package di

import data.preference.CreateDateStorePath
import org.koin.dsl.module

val platformSpecific = module {
    single {
        CreateDateStorePath()
    }
}