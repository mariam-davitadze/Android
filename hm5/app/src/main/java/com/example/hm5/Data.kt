package com.example.hm5

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DATA")
data class Data(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "RUN_ID")
    val id: Int,
    @ColumnInfo(name = "RUN_DISTANCE")
    val distance: Int?,
    @ColumnInfo(name = "SWIMMING_DISTANCE")
    val swimming: Int?,
    @ColumnInfo(name = "BURN_CALORIES")
    val calories: Int?

)