package com.ghanshyam.brainiac

data class Quiz(
    var id: String = "",
    var title: String = "",
    var questions: MutableMap<String, Questions> = mutableMapOf()
)