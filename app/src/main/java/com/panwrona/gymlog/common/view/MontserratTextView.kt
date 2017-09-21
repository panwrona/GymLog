package com.panwrona.gymlog.common.view

import android.content.Context
import android.support.annotation.IdRes
import android.support.v4.content.res.ResourcesCompat
import android.util.AttributeSet
import android.widget.TextView
import com.panwrona.gymlog.R

class MontserratTextView constructor(context: Context, attrs: AttributeSet): TextView(context, attrs) {

    @IdRes val fontType: Int

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MontserratTextView)
        fontType = typedArray.getResourceId(R.styleable.MontserratTextView_fontType, R.font.montserrat_regular)
        typedArray.recycle()
        setFontType()
    }

    private fun setFontType() {
        typeface = ResourcesCompat.getFont(context, obtainFontId())
    }

    private fun obtainFontId() = when(fontType) {
            0 -> R.font.montserrat_thin
            1 -> R.font.montserrat_light
            2 -> R.font.montserrat_regular
            3 -> R.font.montserrat_medium
            4 -> R.font.montserrat_semibold
            5 -> R.font.montserrat_bold
            6 -> R.font.montserrat_italic
            else -> R.font.montserrat_regular
        }
}