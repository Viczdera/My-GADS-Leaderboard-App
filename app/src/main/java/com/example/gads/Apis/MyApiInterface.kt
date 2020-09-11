package com.example.gads.Apis

import com.example.gads.Model.HrItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL="https://gadsapi.herokuapp.com/api/"
interface MyApiInterface {
    @GET("volley_array.json")
        fun getHr() :Call<List<HrItem>>

    companion object{
          operator fun invoke() : MyApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(MyApiInterface::class.java)
        }
    }

}
