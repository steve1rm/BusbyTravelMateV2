package presentation.designsystem.components

enum class Duration {
    SHORT_DURATION,
    LONG_DURATION
}

interface ShowMessageManager {
    fun showMessage(message: String, duration: Duration)
}

expect class ShowMessageManagerImp : ShowMessageManager{
    override fun showMessage(message: String, duration: Duration)
}
