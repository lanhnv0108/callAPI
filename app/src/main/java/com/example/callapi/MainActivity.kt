package com.example.callapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.callapi.api.ApiService
import com.example.callapi.model.Currency
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* val job = Job(1, "IT")
         val mListFavorite = arrayListOf<Favorite>()
         with(mListFavorite) {
             add(Favorite(1, "Music"))
             add(Favorite(2, "Read Book"))
             add(Favorite(3, "Swimming"))
             add(Favorite(4, "Run"))
         }
         val user = User(1, "Bin", true, job, mListFavorite)
         Log.e("JSON", Gson().toJson(user))*/
        //    http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
        btn_call.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        ApiService.retrofit.convertUsdToVnd(
            "843d4d34ae72b3882e3db642c51e28e6",
            "VND",
            "USD",
            1
        ).enqueue(object : Callback<Currency> {
            override fun onResponse(call: Call<Currency>?, response: Response<Currency>?) {
                Toast.makeText(this@MainActivity, "Call API Success", Toast.LENGTH_SHORT).show()
                val currency: Currency = response?.body()!!
                currency.apply{
                    text.text = currency.terms
                }
            }

            override fun onFailure(call: Call<Currency>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}