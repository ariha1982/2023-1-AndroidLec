package com.example.subeye

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService2 {
    @GET("getSubwaySttnExitAcctoCfrFcltyList")
    fun getList(
        @Query("serviceKey") apiKey : String,
        @Query("_type") returnType : String,
        @Query("subwayStationId") stationId : String
    ) : Call<MyBody2>
}