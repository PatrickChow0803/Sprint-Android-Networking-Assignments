package com.patrickchow.broadcastassignment

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.lang.UnsupportedOperationException

class ImageDownloadService: Service(){

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("LargeImageDownload", "started")

        Thread(Runnable (){
            val bitmap = NetworkAdapter.getBitmapFromUrl("https://i.imgur.com/HaSmgGn.jpg")
            
            stopSelf()
        }).start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("LargeImageDownload", "created")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LargeImageDownload", "destroyed")
    }

    override fun onBind(p0: Intent?): IBinder? {
        throw UnsupportedOperationException()

    }



}
