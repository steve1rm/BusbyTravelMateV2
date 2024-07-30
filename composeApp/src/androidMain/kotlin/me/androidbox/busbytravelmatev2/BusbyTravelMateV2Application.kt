package me.androidbox.busbytravelmatev2

import android.app.Application
import di.initializeKoin

class BusbyTravelMateV2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }
}