package com.patrickchow.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.patrickchow.httpoperations.model.Employee
import com.patrickchow.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PutActivity : AppCompatActivity(), Callback<Employee> {
    override fun onFailure(call: Call<Employee>, t: Throwable) {

    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        if(response.isSuccessful) {
            response.body()?.let {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this, "FAILURE", Toast.LENGTH_SHORT).show()
        }
    }

    lateinit var employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)
        title = "Put Request: Update existing Employee Steve"

        // TODO: Create the API object
        employeesService = JsonPlaceHolderApi.Factory.create()
        updateEmployee()
    }

    private fun updateEmployee(){
        // TODO: Write the call to update an employee
        val employee = Employee("Steve", 1, 25, "Principal Engineer")
        employeesService.updateEmployee(employee).enqueue(this)
    }

}