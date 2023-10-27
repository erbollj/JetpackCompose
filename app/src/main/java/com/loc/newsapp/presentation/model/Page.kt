package com.loc.newsapp.presentation.model

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page("Salam", "Kandai", R.drawable.onboarding1),
    Page("Privet", "Kak tu", R.drawable.onboarding2),
    Page("Hello", "How are you", R.drawable.onboarding3)
)
