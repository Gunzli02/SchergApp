package com.example.schergapp

import Models.Contact
import com.fasterxml.jackson.module.kotlin.*
import okhttp3.*
import java.io.IOException

class BackendEndConnection(
    private val client: OkHttpClient = OkHttpClient(),
    private val backendConnectionString: String = "http://10.0.2.2:8080"
) {
    private val contactEndpointString = "/contacts"
    private val mapper = jacksonObjectMapper()

    fun getAllContacts(): List<Contact> {
        val requestUrl = backendConnectionString + contactEndpointString
        var contactList = mutableListOf<Contact>()

        val request = Request.Builder().url(requestUrl).build()
        var result = "requestNotSuccesfull -Lukas"

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
//                    contactList.addAll(ObjectMapper().readValue(response.body!!.string()))
                    contactList.addAll(mapper.readValue<List<Contact>>(response.body!!.string()))

                    println("Liste befüllen erfolgreich")
                }

            }
        })

        return contactList
    }
}