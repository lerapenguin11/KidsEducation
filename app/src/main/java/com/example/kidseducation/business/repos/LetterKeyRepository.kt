package com.example.kidseducation.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kidseducation.business.model.ReadingModel

class LetterKeyRepository {

    fun getLetterListReading(letter: MutableList<ReadingModel>): LiveData<MutableList<ReadingModel>> {
        val mutableData = MutableLiveData<MutableList<ReadingModel>>()
        val list = mutableListOf<ReadingModel>()

        for (i in letter){
            val id  = i.id
            val textAnswer = i.textAnswer
            val keys = i.keys
            val icon = i.icon
            val countLetter = i.countLetter
            val defaultText = i.defualtText

            val listLetterModel = ReadingModel(
                id = id, textAnswer = textAnswer, keys = keys, icon = icon, countLetter = countLetter,
                defualtText = defaultText
            )
            list.add(listLetterModel)
        }

        mutableData.value = list

        return mutableData
    }
}