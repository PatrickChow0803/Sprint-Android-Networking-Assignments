package com.patrickchow.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.patrickchow.httpoperations.model.Employee
import com.patrickchow.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetActivity : AppCompatActivity(), Callback<List<Employee>> {

    override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
        Toast.makeText(this@GetActivity,"Failed", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(
        call: Call<List<Employee>>,
        response: Response<List<Employee>>
    ) {
        response.body()?.let{
            Toast.makeText(this@GetActivity, it.toString(), Toast.LENGTH_SHORT).show()
        }}

    lateinit var employeesService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        // TODO: Create the api
        employeesService = JsonPlaceHolderApi.Factory.create()

        val type = intent.getStringExtra("get")
        if (type == "simple") {
            title = "GET - Simple Request"
            getEmployees()
        } else if (type == "path") {
            title = "GET - Path Parameter: EmployeeId - 2"
            getEmployeesById("2")
        }
        else{
            title = "GET - Query Parameter: Age - 45"
            getEmployeesByAge("45")
        }
    }

    private fun getEmployees(){
        // TODO: Write the call for getting all employees
        employeesService.getEmployees().enqueue(this)
    }

    private fun getEmployeesById(employeeId: String){
        // TODO: Write the call to get an employee by id
        employeesService.getEmployeesById(employeeId).enqueue(this)
    }

    private fun getEmployeesByAge(age: String){
        // TODO: Write the call to get an employee by age
        employeesService.getEmployeesByAge(age).enqueue(this)
    }
}