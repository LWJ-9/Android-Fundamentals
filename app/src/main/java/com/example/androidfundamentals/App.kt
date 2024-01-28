package com.example.androidfundamentals

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class App: Application() {
    companion object {
        const val TAG = "App"
    }

    lateinit var appNotificationDelegate : AppNotificationDelegate


    override fun onCreate() {
        super.onCreate()
        Log.v("App", "onCreate")
        appNotificationDelegate = AppNotificationDelegate(this)
    }

    override fun onLowMemory() {
        showLifecycleNotification("onLowMemory")
        super.onLowMemory()
    }

    override fun onTerminate() {
        showLifecycleNotification("onTerminate")
        super.onTerminate()
    }

    override fun onTrimMemory(level: Int) {
        showLifecycleNotification("onTrimMemory with level $level")
        super.onTrimMemory(level)
    }


    fun showLifecycleNotification(text: String) : Int =
        appNotificationDelegate.showLifecycleNotification(text, TAG)



}