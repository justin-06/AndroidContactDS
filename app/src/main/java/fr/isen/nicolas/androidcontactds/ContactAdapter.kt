package fr.isen.nicolas.androidcontactds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var contacts: Array<String>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val cellSurname : TextView = view.findViewById<TextView>(R.id.prenom_contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)

        return ContactViewHolder(view)
    }


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val Contacts = contacts[position]
        holder.cellSurname.text = Contacts

}
override fun getItemCount(): Int = contacts.size

}