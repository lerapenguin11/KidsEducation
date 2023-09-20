package com.example.kidseducation.business.model

import com.example.kidseducation.R

object Constants {

    fun getReading() : MutableList<ReadingModel>{

        val readingList = mutableListOf<ReadingModel>()

        val reading1 = ReadingModel(0, R.string.giraffe, mutableListOf("G", "I", "R", "A", "F", "F", "E"),
            R.drawable.giraffe, 7, mutableListOf("", "", "", "", "", "", ""))

        readingList.add(reading1)

        val reading2 = ReadingModel(1, R.string.hippo, mutableListOf("H", "I", "P", "P", "O"),
            R.drawable.hippo, 5, mutableListOf("", "", "", "", ""))

        readingList.add(reading2)

        return readingList
    }

    fun getNumber() : MutableList<NumberModel>{

        val readingList = mutableListOf<NumberModel>()

        val reading1 = NumberModel(0, R.drawable.ic_1, 1, listOf(OptionModel(R.string.one, R.string.nine, 0, 1)))

        readingList.add(reading1)


        return readingList
    }
}