package com.example.kidseducation.business.repos

import androidx.lifecycle.LiveData
import com.example.kidseducation.business.datebase.ResultDao

class ResultRepository(private val resultDao: ResultDao) {
    val allResult: LiveData<List<com.example.kidseducation.business.datebase.Result>> = resultDao.getAllResult()

    suspend fun insertResult(result: com.example.kidseducation.business.datebase.Result) {
        resultDao.insertResult(result)
    }

    suspend fun deleteResult(result: List<com.example.kidseducation.business.datebase.Result>) {
        resultDao.deleteResult(result)
    }
}