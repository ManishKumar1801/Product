package com.example.product

import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("/products")
    fun getProduct():Call<Data>
}

