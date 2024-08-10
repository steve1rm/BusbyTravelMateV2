class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()
actual fun isDebug(): Boolean {
    /** Find platform specific for wasm */
    return true
}