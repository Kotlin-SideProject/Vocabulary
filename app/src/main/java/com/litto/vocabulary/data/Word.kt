package com.litto.vocabulary.data

data class Word(
    val name: String,
    val means: String,
    val difficulty: Int,
    val star : Int
) {
    var id: Long? = null
}