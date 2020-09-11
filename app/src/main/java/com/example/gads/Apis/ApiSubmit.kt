package com.example.gads.Apis

import com.example.gads.Model.DefaultSubmitResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiSubmit {
    @FormUrlEncoded
    @POST("formResponse")
    fun formResponse(

        @Field("entry.1824927963") email:String,
        @Field("entry.1877115667") firstname:String,
        @Field("entry.2006916086") lastname:String,
        @Field("entry.1877115667") gitproject:String

    ):Call<DefaultSubmitResponse>
}