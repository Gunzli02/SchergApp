package com.example.schergapp.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.schergapp.contact_list
import com.example.schergapp.model.Contact

class ContactListViewModel: ViewModel() {

    // list that actually holds the items
    private val stateList = contact_list.toMutableStateList()

    // read-only getter to get list entries without modifying them
    val list: MutableList<Contact>
        get() = stateList

    // function to delete an entry from the state list
    fun remove(entry: Contact) {
        stateList.remove(entry)
    }

}