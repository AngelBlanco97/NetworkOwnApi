package com.angelblanco.networkownapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.angelblanco.networkownapi.databinding.FragmentListAgendaBinding
import com.angelblanco.networkownapi.network.NetworkConfig
import com.angelblanco.networkownapi.network.requests.AgendaRequest
import com.angelblanco.networkownapi.network.response.AgendaResponse
import com.angelblanco.networkownapi.network.response.toModel
import kotlinx.android.synthetic.main.fragment_list_agenda.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentListAgenda : Fragment() {
    private var _binding: FragmentListAgendaBinding? = null
    private val binding
    get() = _binding!!
    private val adapter: AgendaAdapter = AgendaAdapter {
        val action = FragmentListAgendaDirections.actionFragmentListAgendaToFragmentDetailContact(
            it.id,
            it.contacto.toString(),
            it.telefono.toString(),
            it.email.toString()
        )
        findNavController().navigate(action)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListAgendaBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvList.layoutManager = GridLayoutManager(context, 1)
        binding.rvList.adapter = adapter

        getContactos()

        binding.btnAdd.setOnClickListener{
            NetworkConfig.service.addContacto(
                AgendaRequest(binding.etName.text.toString(), binding.etTelf.text.toString(), binding.etEmail.text.toString())
            ).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful){
                        adapter.notifyDataSetChanged()
                        et_Name.setText("")
                        et_Email.setText("")
                        et_Telf.setText("")
                        getContactos()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Error al cargar contactos", Toast.LENGTH_LONG).show()

                }

            })
        }


    }



    private fun getContactos() {
        NetworkConfig.service.getContactos().enqueue(object : Callback<List<AgendaResponse>>{
            override fun onResponse(
                call: Call<List<AgendaResponse>>,
                response: Response<List<AgendaResponse>>
            ) {
                if (response.isSuccessful) {

                    if (response.body()?.isEmpty() == true){
                        Toast.makeText(context, "No hay contactos", Toast.LENGTH_SHORT).show()
                    }
                    val person = response.body()?.toModel()
                    adapter.submitList( person ?: emptyList())
                    adapter.notifyDataSetChanged()


                } else {
                    Toast.makeText(context, "Error al cargar contactos.", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<AgendaResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}