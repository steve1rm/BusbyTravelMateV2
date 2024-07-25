package me.androidbox.busbytravelmatev2

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val permissionFactory = rememberPermissionsControllerFactory()
            val controller = permissionFactory.createPermissionsController()

            controller.bind(this)

            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}