package com.example.androidfundamentals.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.androidfundamentals.AppNotificationDelegate.Companion.RUNNING_CHANNEL_ID
import com.example.androidfundamentals.R

class RunningService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {

        super.onDestroy()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when (intent?.action) {
            Action.START.name -> {
                // start service
                start()
            }
            Action.STOP.name -> {
                // stop service
                stopSelf()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
    enum class Action {
        START,
        STOP
    }
    private fun start(){
        val notification = NotificationCompat.Builder(this, RUNNING_CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("Elapsed time: 100 seconds")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()
        // start service
        startForeground(1, notification)
    }

}