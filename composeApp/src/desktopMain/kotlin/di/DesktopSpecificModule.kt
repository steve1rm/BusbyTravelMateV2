package di

import org.koin.dsl.module
import presentation.designsystem.components.ShowMessageManager
import presentation.designsystem.components.ShowMessageManagerImp

val desktopSpecificModule = module {

    factory<ShowMessageManager> {
        ShowMessageManagerImp()
    }
}