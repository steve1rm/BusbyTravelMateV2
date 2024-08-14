package di

import org.koin.dsl.module

val nativeSpecificModule = module {
    KeyChainSettings("${NSBundle.mainBundle.bundleIdentifier}.AUTH")
}