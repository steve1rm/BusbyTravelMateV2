package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import presentation.di.presentationModule

fun initializeKoin(koinConfig: KoinAppDeclaration? = null) {

    startKoin {
        koinConfig?.invoke(this@startKoin)

        this.modules(
            appModule,
            presentationModule
        )
    }
}