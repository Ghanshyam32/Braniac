package com.ghanshyam.brainiac

class IconPicker {
    val icon = arrayOf(R.drawable.movie, R.drawable.brain, R.drawable.sports)
    var currentIconIndex = 0

    fun getIcon(): Int {
        currentIconIndex = (currentIconIndex + 1) % icon.size
        return icon[currentIconIndex]
    }
}