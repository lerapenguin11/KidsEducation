package com.example.kidseducation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kidseducation.business.model.Constants
import com.example.kidseducation.business.model.ReadingModel
import com.example.kidseducation.business.repos.LetterKeyRepository

class ReadingViewModel : ViewModel() {

    private val repository = LetterKeyRepository()

    fun getResultEquipment(): LiveData<MutableList<ReadingModel>> {
        val mutableData = MutableLiveData<MutableList<ReadingModel>>()
        repository.getLetterListReading(Constants.getReading()).observeForever { list ->
            mutableData.value = list
        }

        return mutableData
    }
}