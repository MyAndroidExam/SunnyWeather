package com.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    // 使用Retrofit构建者模式创建Retrofit实例，并使用Gson作为数据转换器
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 该方法根据传入的serviceClass创建一个对应的Retrofit服务，并返回该服务的实例
    fun <T> create(serviceClass:Class<T>): T = retrofit.create(serviceClass)

    // 该方法使用reified关键字指定serviceClass的类型，避免显示传入serviceClass参数
    inline fun <reified T> create(): T = create(T::class.java)

}