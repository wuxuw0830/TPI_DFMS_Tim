package com.example.myapplication.ui.attractions

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.MainRepository
import com.example.myapplication.attractions.Attractions
import com.example.myapplication.attractions.AttractionsInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AttractionsViewModel : ViewModel() {
    var attractionInfo = MutableLiveData<List<AttractionsInfo>?>()
    val recoverError = MutableLiveData<Unit>()
     @SuppressLint("SuspiciousIndentation")
     fun getAttractionInfo(lang: String, categoryId: String, lat: Float, long: Float){
      val response=MainRepository.getAttractionAll(lang, categoryId, lat, long)
         response.enqueue(object :Callback<Attractions>{
             override fun onResponse(call: Call<Attractions>, response: Response<Attractions>) {
                 attractionInfo.postValue(response.body()?.data)

             }

             override fun onFailure(call: Call<Attractions>, t: Throwable) {
                 recoverError.postValue(Unit)

             }
         })

    }
}