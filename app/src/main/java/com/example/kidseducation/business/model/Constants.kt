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

        val reading3 = ReadingModel(2, R.string.elephant, mutableListOf("E", "L", "E", "P", "H", "A", "N", "T"),
            R.drawable.elephant, 8, mutableListOf("", "", "", "", "", "", "", ""))

        readingList.add(reading3)

        val reading4 = ReadingModel(3, R.string.tiger, mutableListOf("T", "I", "G", "E", "R"),
            R.drawable.tiger, 5, mutableListOf("", "", "", "", ""))

        readingList.add(reading4)

        val reading5 = ReadingModel(4, R.string.lion, mutableListOf("L", "I", "O", "N"),
            R.drawable.ic_lion, 4, mutableListOf("", "", "", ""))

        readingList.add(reading5)

        val reading6 = ReadingModel(5, R.string.pig, mutableListOf("P", "I", "G"),
            R.drawable.pig, 3, mutableListOf("", "", ""))

        readingList.add(reading6)

        val reading7 = ReadingModel(6, R.string.zebra, mutableListOf("Z", "E", "B", "R", "A"),
            R.drawable.zebra, 5, mutableListOf("", "", "", "", ""))

        readingList.add(reading7)

        val reading8 = ReadingModel(7, R.string.bear, mutableListOf("B", "E", "A", "R"),
            R.drawable.bear, 4, mutableListOf("", "", "", ""))

        readingList.add(reading8)

        val reading9 = ReadingModel(8, R.string.monkey, mutableListOf("M", "O", "N", "K", "E", "Y"),
            R.drawable.monkey, 6, mutableListOf("", "", "", "", "", ""))

        readingList.add(reading9)

        val reading10 = ReadingModel(9, R.string.panda, mutableListOf("P", "A", "N", "D", "A"),
            R.drawable.panda, 5, mutableListOf("", "", "", "", ""))

        readingList.add(reading10)

        val reading11 = ReadingModel(10, R.string.frog, mutableListOf("F", "R", "O", "G"),
            R.drawable.frog, 4, mutableListOf("", "", "", ""))

        readingList.add(reading11)

        return readingList
    }

    fun getNumber() : MutableList<NumberModel>{

        val readingList = mutableListOf<NumberModel>()

        val reading1 = NumberModel(0, R.drawable.ic_1, 1, listOf(OptionModel(R.string.one, R.string.nine, 0, 1)))

        readingList.add(reading1)

        val reading2 = NumberModel(1, R.drawable.ic_2, 1, listOf(OptionModel(R.string.eight, R.string.nine, 1, 2)))

        readingList.add(reading2)

        val reading3 = NumberModel(2, R.drawable.ic_3, 2, listOf(OptionModel(R.string.eight, R.string.seven, 0, 2)))

        readingList.add(reading3)

        val reading4 = NumberModel(3, R.drawable.ic_4, 2, listOf(OptionModel(R.string.one, R.string.six, 0, 2)))

        readingList.add(reading4)

        val reading5 = NumberModel(4, R.drawable.ic_5, 1, listOf(OptionModel(R.string.five, R.string.nine, 1, 2)))

        readingList.add(reading5)

        val reading6 = NumberModel(5, R.drawable.ic_6, 1, listOf(OptionModel(R.string.four, R.string.two, 1, 2)))

        readingList.add(reading6)

        val reading7 = NumberModel(6, R.drawable.ic_7, 1, listOf(OptionModel(R.string.two, R.string.five, 1, 2)))

        readingList.add(reading7)

        val reading8 = NumberModel(7, R.drawable.ic_8, 2, listOf(OptionModel(R.string.two, R.string.one, 1, 2)))

        readingList.add(reading8)

        val reading9 = NumberModel(8, R.drawable.ic_9, 2, listOf(OptionModel(R.string.nine, R.string.three, 1, 2)))

        readingList.add(reading9)

        return readingList
    }
}