package com.lambdaschool.httpoperations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lambdaschool.httpoperations.model.Employee
import com.lambdaschool.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HttpPutActivity : AppCompatActivity(), Callback<Employee> {
    override fun onFailure(call: Call<Employee>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var employeeService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_get)
        title = "Put Request: Update existing Employee Steve"

        // TODO: Create the API object
        employeeService = JsonPlaceHolderApi.Factory.create()
        updateEmployee()
    }

    private fun updateEmployee(){
        // TODO: Write the call to update an employee
        //val employee = Employee()
        //employeeService.updateEmployee(employee).enqueue(this)
    }

}
