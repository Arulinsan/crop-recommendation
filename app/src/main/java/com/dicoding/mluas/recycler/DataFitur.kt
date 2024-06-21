package com.dicoding.mluas.recycler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataFitur(
    val nama : String,
    val desc : String
) : Parcelable
