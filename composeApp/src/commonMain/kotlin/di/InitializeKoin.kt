package di

import data.di.dataModule
import domain.di.domainModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import presentation.di.presentationModule

fun initializeKoin(koinConfig: KoinAppDeclaration? = null, vararg additionalModules: Module) {

    startKoin {
        koinConfig?.invoke(this@startKoin)

        this.modules(
            appModule,
            presentationModule,
            domainModule,
            dataModule,
            *additionalModules
        )
    }
}