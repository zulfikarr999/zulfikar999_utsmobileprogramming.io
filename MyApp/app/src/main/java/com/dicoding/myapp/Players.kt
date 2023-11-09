package com.dicoding.myapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Players(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
