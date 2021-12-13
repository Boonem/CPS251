package com.mattboone.contactsproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mattboone.contactsproject.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mattboone.contactsproject.Contact
import androidx.fragment.app.viewModels
import com.mattboone.contactsproject.MainActivity

import java.util.*

import com.mattboone.contactsproject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }
    private fun clearFields() {

        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()

            if (name != "" && number != "") {
                val contact = Contact(name, Integer.parseInt(number))
                viewModel.insertContact(contact)
                clearFields()
            } else {
                (activity as MainActivity)!!.showToast("You must enter a name and a phone number")
            }
        }

        binding.findButton.setOnClickListener {

            val name = binding.contactName.text.toString()

            if (name != "") {
                viewModel.findContact(binding.contactName.text.toString())
                clearFields()
            } else {
                (activity as MainActivity)!!.showToast("You must enter a search criteria in the name field")
            }
        }

        /*binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.contactName.text.toString())
            clearFields()
        }*/

        binding.ascButton.setOnClickListener {
            viewModel.getAscContacts()
        }
        binding.descButton.setOnClickListener {
            viewModel.getDescContacts()
        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        /*viewModel.getAscContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getDescContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.fContact().observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })*/

        viewModel.getSearchResults().observe(this, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                    /*binding.contactID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.contactName.setText(it[0].contactName)
                    binding.contactNumber.setText(String.format(Locale.US, "%d",
                        it[0].contactNumber))*/
                } else {
                    (activity as MainActivity)!!.showToast("There are no contacts that match your search")
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.itemClickedListener{
            override fun onCLick(id: String) {
                var contactID: Int = parseInt(id)
                viewModel.deleteContact(contactID)
            }
        })
    }

}