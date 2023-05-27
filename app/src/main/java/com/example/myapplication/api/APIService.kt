package com.example.myapplication.api

import com.example.myapplication.attractions.Attractions
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface APIService {
    @GET("open-api/{lang}/Attractions/All")
    @Headers("Accept: application/json")
     fun getAttractionAll(
        @Path("lang") lang: String,
        @Query("categoryIds") categoryIds: String,
        @Query("nlat") latitude: Float,
        @Query("elong") longtitude: Float,
        @Query("page") page: String = "1"
    ): Call<Attractions>
}