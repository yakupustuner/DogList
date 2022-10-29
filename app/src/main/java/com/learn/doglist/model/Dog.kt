package com.learn.doglist.model

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("status")
    var status:String,
    @SerializedName("message")
    var message:List<String>,


)
