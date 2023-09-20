package com.example.kidseducation.business.model

data class ReadingModel(
    val id : Int,
    val textAnswer : Int,
    val keys : MutableList<String>,
    val icon : Int,
    val countLetter : Int,
    val defualtText : MutableList<String>
)