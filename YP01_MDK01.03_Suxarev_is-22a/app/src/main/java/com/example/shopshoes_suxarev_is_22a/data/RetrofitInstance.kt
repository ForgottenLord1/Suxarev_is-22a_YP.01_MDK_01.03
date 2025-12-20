package com.example.shopshoes_suxarev_is_22a.data

import com.example.myfirstapplication.data.service.UserMenegmentService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson

import java.net.InetSocketAddress
import java.net.Proxy
import kotlin.jvm.java

object RetrofitInstance {
    const val SUPABASE_URL = "https://rycezphsndcufbguofvr.supabase.co/"
    private val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.77", 3128))
    var client: OkHttpClient = OkHttpClient.Builder().proxy(proxy).build()
    //private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(SUPABASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val userMenegmentService = retrofit.create(UserMenegmentService::class.java)
}