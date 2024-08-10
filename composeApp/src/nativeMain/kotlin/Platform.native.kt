import kotlin.native.runtime.Debugging

actual fun isDebug(): Boolean {
    var isDebug = false
    #if DEBUG
    isDebug = true
    #endif

    return isDebug
}