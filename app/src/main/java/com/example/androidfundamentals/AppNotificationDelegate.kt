package com.example.androidfundamentals

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AppNotificationDelegate(context: Context) {
    companion object {
        const val TAG = "AppNotificationDelegate"
        private lateinit var mNotificationManager: NotificationManager
        private var mNotificationId = 0
        private lateinit var applicationContext: Context
    }
    private val context = context
    init {
        applicationContext = context.applicationContext
        mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        initChannels()
    }

    fun showLifecycleNotification(text: String,tag:String) : Int {
        val channelId = "lifecycle_channel"

        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Lifecycle ID: $mNotificationId")
            .setContentText("$tag $text")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        Log.v(TAG, "showLifecycleNotification: $tag $text")
        mNotificationManager.notify(mNotificationId, notification)
        return mNotificationId++
    }

    fun requestPermissions() {
        if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            context.startActivity(intent)
        }
    }

    private fun initChannels() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return
        }
        val channels: List<String> = listOf(
            "lifecycle_channel"
        )
        val channelName: Map<String, String> = mapOf(
            "lifecycle_channel" to "Lifecycle Notifications"
        )
        val channelImportance: Map<String, Int> = mapOf(
            "lifecycle_channel" to NotificationManager.IMPORTANCE_DEFAULT
        )
        channels.forEach {
            val channel = NotificationChannel(it, channelName[it], channelImportance[it]!!)
            mNotificationManager.createNotificationChannel(channel)
        }

    }
}