package com.ekremozan.services

import android.R
import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class SampleForegroundService: Service() {

    private val CHANNEL_ID = "ForegroundServiceChannel"
    override fun onCreate() {
        Log.v("SampleTest", "onCreate - " + Thread.currentThread().name)
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent!!.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_menu_save)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        //do heavy work on a background thread


        //stopSelf();
        return START_NOT_STICKY
    }

    override fun onStart(intent: Intent?, startId: Int) {
        Log.v("SampleTest", "onStart - " + Thread.currentThread().name)
        super.onStart(intent, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.v("SampleTest", "onBind - " + Thread.currentThread().name)
        return null
    }

    override fun onDestroy() {
        Log.v("SampleTest", "onDestroy - " + Thread.currentThread().name)
        super.onDestroy()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }
}