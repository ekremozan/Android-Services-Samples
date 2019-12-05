package com.ekremozan.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SampleService : Service() {

    override fun onCreate() {
        Log.v("SampleTest", "onCreate - " + Thread.currentThread().name)
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v("SampleTest", "onStartCommand - " + Thread.currentThread().name)
        return START_STICKY
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
}