package com.ekremozan.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class SampleIntentService: IntentService(SampleService::class.java.simpleName) {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v("SampleTest", "onStartCommand - " + Thread.currentThread().name)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        Log.v("SampleTest", "onCreate - " +  Thread.currentThread().name)
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        Log.v("SampleTest", "onStart - " +  Thread.currentThread().name)
        super.onStart(intent, startId)
    }

    override fun onDestroy() {
        Log.v("SampleTest", "onDestroy - " +  Thread.currentThread().name)
        super.onDestroy()
    }

    override fun onHandleIntent(p0: Intent?) {
        Log.v("SampleTest", "onHandleIntent - " +  Thread.currentThread().name)
        Thread.sleep(9000)
    }
}