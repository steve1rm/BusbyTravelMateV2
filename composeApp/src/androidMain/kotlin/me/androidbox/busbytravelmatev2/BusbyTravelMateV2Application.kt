package me.androidbox.busbytravelmatev2

import android.app.Application
import data.di.dataModule
import data.preference.CreateDateStorePath
import di.initializeKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class BusbyTravelMateV2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin {
            androidContext(this@BusbyTravelMateV2Application)
            modules(
                module {
                    single { CreateDateStorePath(androidContext())}
                }
            )
        }
    }
}