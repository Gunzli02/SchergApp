package com.example.schergapp.data

import com.example.schergapp.model.Contact
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ContactsApiService {

    @GET("/contacts")
    fun getContacts(): Call<List<Contact>>

    @DELETE("/contacts/{id}")
    fun deleteContact(@Path("id") id: Int): Call<ResponseBody>


}