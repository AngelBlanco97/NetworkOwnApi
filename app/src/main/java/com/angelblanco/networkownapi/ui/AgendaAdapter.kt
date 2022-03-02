package com.angelblanco.networkownapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.angelblanco.networkownapi.databinding.ItemContactoBinding
import com.angelblanco.networkownapi.model.Agenda

class AgendaAdapter(private val onClick:(Agenda)->Unit): ListAdapter<Agenda, AgendaAdapter.ViewHolder>(MessageItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = getItem(position)
        with(holder.binding) {
            txtName.text = person.contacto
            txtTlf.text = person.telefono
        }

        holder.binding.root.setOnClickListener{
            onClick(person)
        }
    }

    inner class ViewHolder(val binding: ItemContactoBinding) : RecyclerView.ViewHolder(binding.root)
}

object MessageItemCallback : DiffUtil.ItemCallback<Agenda>() {
    override fun areItemsTheSame(oldItem: Agenda, newItem: Agenda): Boolean =
        oldItem.idContacto == newItem.idContacto

    override fun areContentsTheSame(oldItem: Agenda, newItem: Agenda): Boolean =
        oldItem.idContacto == newItem.idContacto
}