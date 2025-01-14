package com.patrickchow.basicandroidnetworking

import com.google.gson.GsonBuilder
import com.patrickchow.basicandroidnetworking.model.OceaniaCountry
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OceaniaCountriesRetriever {
    companion object{
        const val BASE_URL = "https://restcountries.eu/rest/v2/region/"
    }

    fun getOceaniaCountries(): Call<List<OceaniaCountry>> {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        val countriesAPI = retrofit.create(CountriesAPI::class.java)

        return countriesAPI.getCountries()
    }

}