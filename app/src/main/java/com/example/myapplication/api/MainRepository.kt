package com.example.myapplication.api

import com.example.myapplication.attractions.Attractions

import retrofit2.Call

object MainRepository {

     fun getAttractionAll(lang: String, categoryId: String, lat: Float, long: Float): Call<Attractions> {
        return RetrofitManager.instance.api.getAttractionAll(lang, categoryId, lat, long)

    }

}