package com.example.hm5

import androidx.room.*

@Dao
interface WorkoutData {
    @Query("SELECT SUM(RUN_DISTANCE) AS run_distance FROM data")
    fun getRunDistanceSum(): Float?
    @Query("SELECT AVG(RUN_DISTANCE) AS run_distance FROM data")
    fun getAverageRunDistance(): Float?
    @Query("SELECT AVG(SWIMMING_DISTANCE) as run_swimming FROM data")
    fun getAverageSwimDistance(): Float?
    @Query("SELECT AVG(BURN_CALORIES) AS run_calories FROM data")
    fun getAverageBurnCalories(): Float?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg data : Data)
}