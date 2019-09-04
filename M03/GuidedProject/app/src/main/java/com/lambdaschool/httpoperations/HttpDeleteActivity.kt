package com.lambdaschool.httpoperations

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lambdaschool.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HttpDeleteActivity : AppCompatActivity(), Callback<Void> {
    override fun onFailure(call: Call<Void>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (response.isSuccessful){
            Toast.makeText(this, "successfully deleted employee", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Failed to delete an employee", Toast.LENGTH_SHORT).show()
        }
    }


    lateinit var employeeService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_get)
        title = "Delete Request: Delete existing employee with id 1"

        employeeService = JsonPlaceHolderApi.Factory.create()
        deleteEmployee()
    }

    private fun deleteEmployee(){
        // TODO: delete the employee
        employeeService.deleteEmployeeById("1").enqueue(this)
    }
}
