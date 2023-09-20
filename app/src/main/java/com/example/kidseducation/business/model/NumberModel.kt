package com.example.kidseducation.business.model

data class NumberModel(
    val id : Int,
    val icon : Int,
    val positionAnswer: Int,
    val option: List<OptionModel>
)
