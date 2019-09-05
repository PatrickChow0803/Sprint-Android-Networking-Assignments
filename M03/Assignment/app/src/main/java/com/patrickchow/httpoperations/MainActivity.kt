package com.patrickchow.httpoperations

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get.setOnClickListener {
            if (!isConnected()){
                notConnectedToast()
            }
            else{
                val intent = Intent(this, GetPickerActivity::class.java)
                startActivity(intent)
            }
        }

        btn_post.setOnClickListener{
            if (!isConnected()){
                notConnectedToast()
            }
            else{
                val intent = Intent(this, PostActivity::class.java)
                startActivity(intent)
            }
        }

        btn_delete.setOnClickListener {
            if (!isConnected()){
                notConnectedToast()
            }
            else{
                val intent = Intent(this, DeleteActivity::class.java)
                startActivity(intent)
            }
        }

        btn_put.setOnClickListener{
            if (!isConnected()){
                notConnectedToast()
            }
            else{
                val intent = Intent(this, PutActivity::class.java)
                startActivity(intent)
            }
        }

    }

    //Checks to see if the user is connected to the internet or not.
    private fun isConnected():Boolean{
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        Toast.makeText(this,"Connection = ${networkInfo.isConnected}",Toast.LENGTH_SHORT).show()

        return networkInfo.isConnected
    }

    fun notConnectedToast(){
        Toast.makeText(this,"Not connected", Toast.LENGTH_SHORT).show()
    }
}
