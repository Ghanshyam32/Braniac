package com.ghanshyam.brainiac

class IconPicker {
    val icon = arrayOf(R.drawable.image_brain, R.drawable.img_me, R.drawable.img_earth)
    var currentIconIndex = 0

    fun getIcon(): Int {
        currentIconIndex = (currentIconIndex + 1) % icon.size
        return icon[currentIconIndex]
    }
}