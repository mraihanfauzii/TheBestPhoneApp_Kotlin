package com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Smartphone(
    val name: String,
    val specification: String,
    val photo: String
):Parcelable
