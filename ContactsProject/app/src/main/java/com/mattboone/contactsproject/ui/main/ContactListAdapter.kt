package com.mattboone.contactsproject.ui.main

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mattboone.contactsproject.Contact
import com.mattboone.contactsproject.R

class ContactListAdapter(private val contactItemLayout: Int) :
                RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    var listener: itemClickedListener? = null

    fun settingListener(listener: itemClickedListener?) {
        this.listener = listener
    }

    interface itemClickedListener {
        fun onCLick(string: String)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val contactName = holder.contactName
        val contactNumber = holder.contactNumber
        val contactID = holder.contactID
        var deleteButton = holder.itemImage
        contactList.let {
            contactName.text = it!![listPosition].contactName
            contactNumber.text = it!![listPosition].contactNumber.toString()
            contactID.text = it!![listPosition].id.toString()
        }

        deleteButton.setOnClickListener(View.OnClickListener {
            var id = contactID.text.toString()
            listener?.onCLick(id)
        })
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts:List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var item: TextView = itemView.findViewById(R.id.contact_row)
        var itemImage: ImageView
        var contactName: TextView
        var contactNumber: TextView
        var contactID: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            contactName = itemView.findViewById(R.id.contactName)
            contactNumber = itemView.findViewById(R.id.contactNumber)
            contactID = itemView.findViewById(R.id.contactID)
        }
    }
}