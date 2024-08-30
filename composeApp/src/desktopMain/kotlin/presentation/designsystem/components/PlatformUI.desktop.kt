package presentation.designsystem.components

import java.awt.Color
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JWindow
import javax.swing.Timer

actual class ShowMessageManagerImp : ShowMessageManager {
    actual override fun showMessage(
        message: String,
        duration: Duration
    ) {
        val toastDuration = when (duration) {
            Duration.SHORT_DURATION -> 4
            Duration.LONG_DURATION -> 8
        }

        ToastMessage(message, toastDuration)
    }
}

class ToastMessage(message: String, duration: Int) : JWindow() {
    init {
        val label = JLabel(message)
        label.isOpaque = true
        label.background = Color.BLACK
        label.foreground = Color.WHITE
        label.border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        add(label)

        pack()
        setLocationRelativeTo(null)
        isVisible = true

        // Add a mouse listener to hide the toast on click
        addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                dispose()
            }
        })

        // Use a timer to dispose the toast after the specified duration
        val timer = Timer(duration * 1000) {
            dispose()
        }

        timer.isRepeats = false
        timer.start()
    }
}