package com.example.myapplication.attractions
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

private const val EMPTY = ""

@Parcelize
data class Attractions(
    val total: Int?=0,
    val data: List<AttractionsInfo>?= emptyList()
) : Parcelable

@Parcelize
data class AttractionsInfo(
    val id: Int,
    val name: String = EMPTY,
    val name_zh: String?,
    val open_status: Int,
    val introduction: String = EMPTY,
    val open_time: String = EMPTY,
    val zipcode: String = EMPTY,
    val distric: String = EMPTY,
    val address: String = EMPTY,
    val tel: String = EMPTY,
    val fax: String = EMPTY,
    val email: String = EMPTY,
    val months: String = EMPTY,
    val nlat: Float,
    val elong: Float,
    val official_site: String = EMPTY,
    val facebook: String = EMPTY,
    val ticket: String = EMPTY,
    val remind: String = EMPTY,
    val staytime: String = EMPTY,
    val modified: String = EMPTY,
    val url: String = EMPTY,
    val category: List<CategoryInfo>?,
    val target: List<CategoryInfo>?,
    val service: List<CategoryInfo>?,
    val friendly: List<String>?,
    val images: List<ImagesInfo>?,
    val files: List<String>?,
    val links: List<LinksInfo>?
) : Parcelable

@Parcelize
data class CategoryInfo(
    val id: Int,
    val name: String
) : Parcelable

@Parcelize
data class ImagesInfo(
    val src: String,
    val subject: String,
    val ext: String?
) : Parcelable

@Parcelize
data class LinksInfo(
    val src: String,
    val subject: String
) : Parcelable
