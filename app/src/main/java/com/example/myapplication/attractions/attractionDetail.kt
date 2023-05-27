package com.example.myapplication.attractions

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AttractionDetail(
    val url:String?,
    val introduce:String?,
    val address:String?,
    val linkUrl:String
):Parcelable
