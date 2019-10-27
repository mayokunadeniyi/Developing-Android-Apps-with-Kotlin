package com.example.android.dessertpusher

import android.app.Application
import timber.log.Timber

/**
 * Created by Mayokun Adeniyi on 2019-10-25.
 */

class PusherApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}