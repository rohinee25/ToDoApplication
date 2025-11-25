package me.rohinee.todo.service


import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    companion object {
        const val ACTION_START = "me.rohinee.todo.action.START_SERVICE"
        const val ACTION_STOP = "me.rohinee.todo.action.STOP_SERVICE"
        private const val TAG = "MyService"
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        when (action) {
            ACTION_START -> {
                Log.i(TAG, "Service start requested")
                Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
                // Do background work here. For demo we just log.
            }
            ACTION_STOP -> {
                Log.i(TAG, "Service stop requested")
                Toast.makeText(this, "Service stopping", Toast.LENGTH_SHORT).show()
                stopSelf()
            }
            else -> {
                Log.i(TAG, "Service received unknown action: $action")
            }
        }
        // Use START_NOT_STICKY unless you need restart after killed
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Service destroyed")
    }
}