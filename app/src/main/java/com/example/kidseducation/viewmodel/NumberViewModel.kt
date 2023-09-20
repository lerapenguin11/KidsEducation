package com.example.kidseducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kidseducation.business.model.Constants
import com.example.kidseducation.business.model.NumberModel
import com.example.kidseducation.business.repos.NumberRepository

class NumberViewModel : ViewModel(){

    private val repository = NumberRepository()

    fun getResultNumber(): LiveData<MutableList<NumberModel>> {
        val mutableData = MutableLiveData<MutableList<NumberModel>>()
        repository.getNumberListReading(Constants.getNumber()).observeForever { list ->
            mutableData.value = list
        }

        return mutableData
    }
}