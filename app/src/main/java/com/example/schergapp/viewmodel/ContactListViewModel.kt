package com.example.schergapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.schergapp.contact_list
import com.example.schergapp.model.Contact

class ContactListViewModel: ViewModel() {

    // list that actually holds the items
    private val stateList = mutableStateListOf<Contact>()
    private var needsRefresh = true;

    // read-only getter to get list entries without modifying them
    val list: MutableList<Contact>
        get() = stateList

    val isNeedsRefresh: Boolean
        get() = needsRefresh

    // function to delete an entry from the state list
    fun remove(entry: Contact) {
        stateList.remove(entry)
    }

    fun initializeList(initialList: MutableList<Contact>) {
        stateList.clear()
        stateList.addAll(initialList)
        needsRefresh = false;
    }

}