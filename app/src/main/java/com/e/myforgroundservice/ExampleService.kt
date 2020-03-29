package com.e.myforgroundservice

import android.R
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.e.myforgroundservice.App.Companion.CHANNEL_ID


class ExampleService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra("inputExtra")

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_delete)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        return START_NOT_STICKY;
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}