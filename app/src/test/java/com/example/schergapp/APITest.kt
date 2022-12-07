package com.example.schergapp

import com.example.schergapp.data.ContactsApiService
import com.example.schergapp.model.Contact
import org.junit.Assert
import org.junit.Test
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APITest {

    @Test
    fun initApiTest() {
        var api: ContactsApiService? = null
        val rf: Retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").build()
        api = rf.create(ContactsApiService::class.java)
    }

    @Test
    fun getListTest() {
        var api: ContactsApiService? = null
        val rf: Retrofit = Retrofit.Builder().baseUrl("http://localhost:8080/").addConverterFactory(GsonConverterFactory.create()).build()
        api = rf.create(ContactsApiService::class.java)

        val contacts: Response<List<Contact>>? = api?.getContacts()?.execute()
        Assert.assertNotNull(contacts)
        if (contacts != null) {
            Assert.assertTrue(contacts.isSuccessful)

            val list: List<Contact>? = contacts.body()
            println(list)
        }
    }

}