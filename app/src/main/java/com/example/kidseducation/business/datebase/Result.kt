package com.example.kidseducation.business.datebase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val  id : Int = 0,
    val text : Int,
    val icon : Int
)
