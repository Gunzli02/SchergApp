import Models.Contact
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.schergapp.contact_list

class ContactViewModel() : ViewModel() {
    private val _contacts = contact_list.toMutableStateList()
    val contacts: MutableList<Contact>
        get() = _contacts


    fun remove(item: Contact) {
        _contacts.remove(item)
    }
}
