package ir.shchooltech.pressroid

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PressroidApp:Application() {
    override fun onCreate() {
        super.onCreate()
        // Get UI mode and set
        val mode = if (false) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }

        AppCompatDelegate.setDefaultNightMode(mode)
    }



}