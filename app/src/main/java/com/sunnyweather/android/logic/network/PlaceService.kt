package com.sunnyweather.android.logic.network

import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    //searchPlaces 方法使用了 @Query 注解，表示 query 参数是一个查询字符串。当调用 searchPlaces 方法时，可以通过传入 query 参数来指定要搜索的地点名称。
    //searchPlaces 方法返回了一个 Call<PlaceResponse> 对象，该对象表示一个异步请求。当请求成功时，Call<PlaceResponse> 对象会返回一个 PlaceResponse 对象，该对象包含了搜索结果。
    //PlaceResponse 对象是一个数据类，它包含了状态、地点列表等信息。当请求失败时，Call<PlaceResponse> 对象会抛出一个异常。
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String): Call<PlaceResponse>

}