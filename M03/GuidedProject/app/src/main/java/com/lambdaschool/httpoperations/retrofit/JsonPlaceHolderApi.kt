package com.lambdaschool.httpoperations.retrofit

import com.google.gson.Gson
import com.lambdaschool.httpoperations.model.Employee
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface JsonPlaceHolderApi {
    // TODO: Create API for different endpoints

    @GET("employees")
    fun getEmployees():Call<List<Employee>>

    @GET("employees/{id}")
    fun getEmployeesById(@Path("id")employeeID: String): Call<List<Employee>>

    @GET("employees")
    fun getEmployeesByAge(@Query("age")employeeID: String): Call<List<Employee>>

    @POST("employees")
    fun addNewEmployee(@Body employee: Employee): Call<Employee>

    @PUT("employee")
    fun updateEmployee(@Body employee: Employee): Call<Employee>

    @DELETE("employees/{id}")
    fun deleteEmployeeById(@Path("id") id:String): Call<Void>

    class Factory{
        companion object{
            val BASE_URL = "https://demo8143297.mockable.io"
            val gson = Gson()
            val logger = HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BASIC
                level = HttpLoggingInterceptor.Level.BODY
            }

            fun create(): JsonPlaceHolderApi{
                return Retrofit.Builder()
                    .baseUrl(JsonPlaceHolderApi.Factory.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(JsonPlaceHolderApi::class.java)
            }
        }
    }
}