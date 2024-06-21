package com.dicoding.mluas.recycler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dataset(
    val nama : String,
    val data : String
) : Parcelable
