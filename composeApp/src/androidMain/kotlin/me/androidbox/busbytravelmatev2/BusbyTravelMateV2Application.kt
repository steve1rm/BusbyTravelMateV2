package me.androidbox.busbytravelmatev2

import android.app.Application
import di.initializeKoin
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import me.androidbox.busbytravelmatev2.di.androidSpecificModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.dsl.module

class BusbyTravelMateV2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin({
            androidLogger()
            androidContext(this@BusbyTravelMateV2Application)
        },
            androidSpecificModule,
            module {
                single<HttpClientEngine> {
                    HttpClient(CIO).engine
                }
            })
    }
}