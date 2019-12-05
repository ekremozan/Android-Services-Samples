package com.ekremozan.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*


class BoundService : Service(){

    private val binder = LocalBinder()

    val currentTime: Date
        get() = Calendar.getInstance().time

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onCreate() {
        Log.v("SampleTest", "onCreate - " + Thread.currentThread().name)
        super.onCreate()
    }

    override fun onDestroy() {
        Log.v("SampleTest", "onDestroy - " + Thread.currentThread().name)
        super.onDestroy()
    }

    inner class LocalBinder : Binder() {
        fun getService(): BoundService = this@BoundService
    }

}