package com.example.documentales.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Documental(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)