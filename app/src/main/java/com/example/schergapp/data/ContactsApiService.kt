package com.example.schergapp.data

import com.example.schergapp.model.Contact
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ContactsApiService {

    @GET("/contacts")
    suspend fun getContacts(): Response<List<Contact>>

    @DELETE("/contacts/{id}")
    suspend fun deleteContact(@Path("id") id: Int): Response<ResponseBody>


}