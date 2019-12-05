package com.ekremozan.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mService: BoundService
    private var mBound: Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as BoundService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun startIntentService(view: View) {
        Intent(this, SampleIntentService::class.java).also { intent ->
            startService(intent)
        }
    }

    fun stopIntentService(view: View) {
        Intent(this, SampleIntentService::class.java).also { intent ->
            stopService(intent)
        }
    }

    fun startNormalService(view: View) {
        Intent(this, SampleService::class.java).also { intent ->
            startService(intent)
        }
    }

    fun stopNormalService(view: View) {
        Intent(this, SampleService::class.java).also { intent ->
            stopService(intent)
        }
    }

    fun startForegroundService(view: View) {
        Intent(this, SampleForegroundService::class.java).also { intent ->
            startService(intent)
        }
    }

    fun stopForegroundService(view: View) {
        Intent(this, SampleForegroundService::class.java).also { intent ->
            stopService(intent)
        }
    }

    fun startBoundService(view: View) {
        Intent(this, BoundService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    fun getCurrentTimeFromBoundService(view: View){
        if (mBound){
        Log.v("SampleTest", mService.currentTime.toString())
        }
    }

    fun stopBoundService(view: View) {
        unbindService(connection)
        mBound = false
    }

}
