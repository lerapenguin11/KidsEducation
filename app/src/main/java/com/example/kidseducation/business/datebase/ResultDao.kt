package com.example.kidseducation.business.datebase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ResultDao {

    @Query("SELECT * FROM result")
    fun getAllResult(): LiveData<List<com.example.kidseducation.business.datebase.Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(result: com.example.kidseducation.business.datebase.Result)

    @Delete
    fun deleteResult(result : List<com.example.kidseducation.business.datebase.Result>)
}