package com.mattboone.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    var searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    var allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name)
        }
    }

    private suspend fun asyncFind(name: String): List<Contact>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }.await()

    fun sortAsc() {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncAsc()
        }
    }

    private suspend fun asyncAsc(): List<Contact>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async  contactDao?.ascContacts()
        }.await()

    fun sortDesc() {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncDesc()
        }
    }

    private suspend fun asyncDesc(): List<Contact>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async  contactDao?.descContacts()
        }.await()
}