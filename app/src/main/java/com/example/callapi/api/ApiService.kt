package com.example.callapi.api


import com.example.callapi.model.Currency
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //    http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apilayer.net/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
                )
            )
            .build()
            .create(ApiService::class.java)
    }

    @GET("api/live")
    fun convertUsdToVnd(
        @Query("access_key") access_key: String,
        @Query("currencies") currencies: String,
        @Query("source") source: String,
        @Query("format") format: Int
    ): Call<Currency>

}