package com.example.schergapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.schergapp.contact_list
import com.example.schergapp.model.Contact
import com.example.schergapp.repository.ContactRepository
import kotlinx.coroutines.*

class ContactListViewModel: ViewModel(), CoroutineScope by MainScope() {

    // list that actually holds the items
    private val stateList = mutableStateListOf<Contact>()
    private val contactRepository: ContactRepository = ContactRepository();

    // read-only getter to get list entries without modifying them
    val list: MutableList<Contact>
        get() = stateList

    // function to delete an entry from the state list
    fun remove(entry: Contact) {
        launch {
            contactRepository.delete(entry.id)
            loadListFromAPI()
        }
    }

    fun loadListFromAPI() {
        launch {
            val newList = contactRepository.getAll().toMutableList()
            stateList.clear()
            stateList.addAll(newList)
        }
    }

}