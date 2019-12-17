package com.patrickchow.basicandroidnetworking

//import retrofit2.Call
import com.patrickchow.basicandroidnetworking.model.OceaniaCountry
import retrofit2.Call
import retrofit2.http.GET

interface CountriesAPI {
        @GET("oceania")
        fun getCountries(): Call<List<OceaniaCountry>>
}