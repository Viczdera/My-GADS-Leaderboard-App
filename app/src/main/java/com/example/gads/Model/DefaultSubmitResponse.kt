package com.example.gads.Model

import com.google.gson.annotations.SerializedName

data class DefaultSubmitResponse (@SerializedName("Error") val Error: String, @SerializedName("Message")val Message:String)