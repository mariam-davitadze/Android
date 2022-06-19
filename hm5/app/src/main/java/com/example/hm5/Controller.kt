package com.example.hm5

import android.app.Application
import androidx.room.Room

class Controller : Application() {
    lateinit var db: DB
    companion object{
        lateinit var instance: Controller
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(
            applicationContext,
            DB::class.java,
            "APP_DATABASE"
        ).allowMainThreadQueries().build()
    }

}