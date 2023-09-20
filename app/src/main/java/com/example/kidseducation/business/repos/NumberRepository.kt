package com.example.kidseducation.business.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kidseducation.business.model.NumberModel

class NumberRepository {

    fun getNumberListReading(number: MutableList<NumberModel>): LiveData<MutableList<NumberModel>> {
        val mutableData = MutableLiveData<MutableList<NumberModel>>()
        val list = mutableListOf<NumberModel>()

        for (i in number){
            val id  = i.id
            val icon = i.icon
            val positionAnswer = i.positionAnswer
            val option = i.option

            val listNumberModel = NumberModel(
                id = id, icon = icon, positionAnswer = positionAnswer, option = option
            )
            list.add(listNumberModel)
        }

        mutableData.value = list

        return mutableData
    }
}