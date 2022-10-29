package com.learn.doglist.API

import com.learn.doglist.model.Dog
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface Retrofit {
    @GET
    suspend fun getDogs(@Url id:String):Response<Dog>
}