package com.patrickchow.httpoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.patrickchow.httpoperations.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteActivity : AppCompatActivity(), Callback<Void> {
    override fun onFailure(call: Call<Void>, t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        if(response.isSuccessful){
            Toast.makeText(this, "Sucessfully deleted employee", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Failed to delete the employee", Toast.LENGTH_SHORT).show()
        }
    }

    lateinit var employeeService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        employeeService = JsonPlaceHolderApi.Factory.create()
        deleteEmployee()
    }

    private fun deleteEmployee(){
        employeeService.deleteEmployeeById("1").enqueue(this)
    }
}
