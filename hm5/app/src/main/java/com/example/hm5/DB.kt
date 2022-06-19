package com.example.hm5
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Data::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun getWorkoutData():WorkoutData
}


