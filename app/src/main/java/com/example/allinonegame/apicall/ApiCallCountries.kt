package com.example.allinonegame.apicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinonegame.apicall.ApiClient.Companion.getRetrofit
import com.example.allinonegame.databinding.ActivityApiCallCountriesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCallCountries : AppCompatActivity() {

    lateinit var apiCallCountriesBinding : ActivityApiCallCountriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        apiCallCountriesBinding = ActivityApiCallCountriesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(apiCallCountriesBinding.root)

        getCountyData()
    }

    fun getCountyData(){

        var apiInterface = getRetrofit().create(ApiInterface::class.java)

        apiInterface.getData().enqueue(object : Callback<List<CountyModelItem>> {
            override fun onResponse(
                call: Call<List<CountyModelItem>>,
                response: Response<List<CountyModelItem>>
            ) {
                var list = response.body()

                setUpRv(list)

                Log.e("TAG", "onResponse: ${list?.get(0)?.alpha2Code}")
            }

            override fun onFailure(call: Call<List<CountyModelItem>>, t: Throwable) {
                Toast.makeText(this@ApiCallCountries, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("TAG", "onError: ${t.message}")

            }
        })
    }

    fun setUpRv(list: List<CountyModelItem>?) {
        var countyAdaptor = CountyAdaptor(this@ApiCallCountries,list)
        var lm = LinearLayoutManager(this)
        apiCallCountriesBinding.rvCounty.adapter = countyAdaptor
        apiCallCountriesBinding.rvCounty.layoutManager = lm
    }


}