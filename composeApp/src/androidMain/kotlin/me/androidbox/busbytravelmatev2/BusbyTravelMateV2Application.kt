package me.androidbox.busbytravelmatev2

import android.app.Application
import di.initializeKoin
import di.platformSpecific
import org.koin.android.ext.koin.androidContext

class BusbyTravelMateV2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin {
            androidContext(this@BusbyTravelMateV2Application)
            modules(
                platformSpecific
            )
        }
    }
}