package com.example.schergapp.repository

import com.example.schergapp.data.ContactsApiService
import com.example.schergapp.model.Contact
import com.example.schergapp.model.IModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class ContactRepository() : IRepository {

    private val contactsApi: ContactsApiService

    init {
        val rf: Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        contactsApi = rf.create(ContactsApiService::class.java)
    }

    override fun getAll(): List<Contact> {
        return try {
            val response: Response<List<Contact>> = contactsApi.getContacts().execute()
            if(!response.isSuccessful) {
                mutableListOf<Contact>()
            }else {
                response.body() ?: mutableListOf<Contact>()
            }
        }catch (e: Exception) {
            mutableListOf<Contact>()
        }
    }

    override fun getByID(id: Int): Contact {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        try {
            val th = Thread(Runnable {
                contactsApi.deleteContact(id).execute()
            })
            th.start()
        } catch (ignored: Exception) {  }
    }

    override fun update(model: IModel) {
        TODO("Not yet implemented")
    }

    override fun create(model: IModel) {
        TODO("Not yet implemented")
    }
}