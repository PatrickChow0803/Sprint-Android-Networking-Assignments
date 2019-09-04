package com.patrickchow.basicandroidnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.patrickchow.basicandroidnetworking.model.OceaniaCountry
import com.patrickchow.basicandroidnetworking.OceaniaCountriesRetriever
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

//If you see a error that says "No type argument expected for interface Callback,
//be sure to import the retrofit2 packages Callback, call, and response
class MainActivity : AppCompatActivity(), Callback<List<OceaniaCountry>> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchCountriesButton.setOnClickListener {

            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)
        }
    }

    override fun onResponse(
        call: Call<List<OceaniaCountry>>,
        response: Response<List<OceaniaCountry>>
    ) {
        if(response.isSuccessful){
            val oceaniaCountryList = response.body() as MutableList<OceaniaCountry>
            var names = ""
            for(index in 0 until oceaniaCountryList.size)
                names += "\n ${oceaniaCountryList[index].name}"
            countriesTextView.text = names
        }
        else{
            val error = "Failure in response: ${response.errorBody().toString()}"
            Toast.makeText(this@MainActivity, error, Toast.LENGTH_LONG).show()
        }
    }

    override fun onFailure(call: Call<List<OceaniaCountry>>, t: Throwable) {

        t.printStackTrace()
        val error = "Fail: ${t.printStackTrace()}"
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_LONG).show()
    }
}

