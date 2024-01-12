package com.sunnyweather.android.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchPlaces(query:String) = liveData(Dispatchers.IO){
        val result = try {
            Log.d("address3_Repository", query)
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            Log.d("address6_Repository", placeResponse.status.toString())

            if (placeResponse.status == "ok"){
                Log.d("address4_Repository", "成功")
                val places = placeResponse.places
                Result.success(places)
            }else{
                Log.d("address5_Repository", "失败")
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }

        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }




}