package com.example.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.product.databinding.ActivityMainBinding
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    lateinit var list: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        list=ArrayList()
        val retrofit= Retrofit.Builder().baseUrl("https://dummyjson.com").addConverterFactory(GsonConverterFactory.create()).build()
        val getApi=retrofit.create(RestApi::class.java)
        getApi.getProduct().enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                list= response.body()?.products!!
                adapter=MyAdapter(this@MainActivity,list)
                binding.recyclerView.adapter=adapter
                binding.recyclerView.layoutManager=LinearLayoutManager(this@MainActivity
                )
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
//        (list as ArrayList<Product>).add(Product("Apple","",
//            "djfjkjng",0.00,0,
//            0,0.0,0,
//            "https://i.dummyjson.com/data/products/15/thumbnail.jpg",
//            "OPPo"))
//        (list as ArrayList<Product>).add(Product("Apple","",
//            "djfjkjng",0.00,0,
//            0,0.0,0,
//            "https://i.dummyjson.com/data/products/15/thumbnail.jpg",
//            "OPPo"))
//        (list as ArrayList<Product>).add(Product("Apple","",
//            "djfjkjng",0.00,0,
//            0,0.0,0,
//            "https://i.dummyjson.com/data/products/15/thumbnail.jpg",
//            "OPPo"))
//        (list as ArrayList<Product>).add(Product("Apple","",
//            "djfjkjng",0.00,0,
//            0,0.0,0,
//            "https://i.dummyjson.com/data/products/15/thumbnail.jpg",
//            "OPPo"))
//        (list as ArrayList<Product>).add(Product("Apple","",
//            "djfjkjng",0.00,0,
//            0,0.0,0,
//            "https://i.dummyjson.com/data/products/15/thumbnail.jpg",
//            "OPPo"))

    }














}