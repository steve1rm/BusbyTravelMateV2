package di

import data.di.dataModule
import domain.di.domainModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import presentation.di.presentationModule

fun initializeKoin(koinConfig: KoinAppDeclaration? = null) {

    startKoin {
        koinConfig?.invoke(this@startKoin)

        this.modules(
            appModule,
            presentationModule,
            domainModule,
            dataModule
        )
    }
}