package me.androidbox.busbytravelmatev2

import android.app.Application
import di.initializeKoin
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

class BusbyTravelMateV2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin {
            modules(
                modules = module {
                    single<HttpClientEngine> {
                        HttpClient(CIO).engine
                    }
                }
            )
        }
    }
}