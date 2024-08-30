package presentation.designsystem.components

import android.content.Context
import android.widget.Toast

actual class ShowMessageManagerImp(private val context: Context) : ShowMessageManager {
    actual override fun showMessage(
        message: String,
        duration: Duration
    ) {
        val toastDuration = when (duration) {
            Duration.SHORT_DURATION -> Toast.LENGTH_SHORT
            Duration.LONG_DURATION -> Toast.LENGTH_LONG
        }
        Toast.makeText(context, message, toastDuration).show()
    }
}
