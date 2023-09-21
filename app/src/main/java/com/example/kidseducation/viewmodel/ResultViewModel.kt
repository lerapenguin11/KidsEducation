package com.example.kidseducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kidseducation.business.repos.ResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel(private val repository: ResultRepository) : ViewModel(){

    val allResult: LiveData<List<com.example.kidseducation.business.datebase.Result>> = repository.allResult

    fun insertResult(result: com.example.kidseducation.business.datebase.Result) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertResult(result)
    }

    fun deleteResult(result: List<com.example.kidseducation.business.datebase.Result>) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteResult(result)
    }
}