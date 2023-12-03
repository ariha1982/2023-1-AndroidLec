package com.example.subeye;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/subeye/NetworkService2;", "", "getList", "Lretrofit2/Call;", "Lcom/example/subeye/MyBody2;", "apiKey", "", "returnType", "stationId", "app_debug"})
public abstract interface NetworkService2 {
    
    @org.jetbrains.annotations.NotNull
    @retrofit2.http.GET(value = "getSubwaySttnExitAcctoCfrFcltyList")
    public abstract retrofit2.Call<com.example.subeye.MyBody2> getList(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "serviceKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "_type")
    java.lang.String returnType, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "subwayStationId")
    java.lang.String stationId);
}