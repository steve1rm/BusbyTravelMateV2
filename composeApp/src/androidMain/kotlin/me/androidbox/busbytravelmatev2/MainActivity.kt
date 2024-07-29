package me.androidbox.busbytravelmatev2

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import data.preference.CreateDateStorePath
import datastore.createDataStore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CreateDateStorePath(context = this)

        setContent(
            content = {
                App(
                    dataStorePreferences = remember {
                        createDataStore(applicationContext)
                    }
                )
            }
        )
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val context = LocalContext.current
    App(createDataStore(context))
}