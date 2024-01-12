package com.sunnyweather.android.ui.place


import android.util.Log
import androidx.lifecycle.*
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()

    // ?重点看变量的类型对PlaceFragment中的result.getOrNull影响
    val placeLiveData = Transformations.switchMap(searchLiveData){
        query -> Repository.searchPlaces(query)
    }


    fun searchPlaces(query: String) {
        searchLiveData.value = query
        Log.d("address1_PlaceViewModel", placeLiveData.toString())
        Log.d("address2_PlaceViewModel", query)
    }







}