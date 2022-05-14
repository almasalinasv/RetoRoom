package com.example.retoroom.database

import android.app.Application

class MyApplication : Application(){
    override fun onCreate() {
        DatabaseManager.instance.initializeDB(applicationContext)
        super.onCreate()
    }
}