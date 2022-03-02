package com.angelblanco.networkownapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.angelblanco.networkownapi.databinding.FragmentDetailContactBinding
import com.angelblanco.networkownapi.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentDetailContact : Fragment() {
    private var _binding: FragmentDetailContactBinding? = null
    private val binding
        get() = _binding!!

    private val args : FragmentDetailContactArgs by navArgs()
    private var idContact: String? = null
    private var nameContact: String? = null
    private var tlfContact: String? = null
    private var emailContact: String? = null

    private val adapter: AgendaAdapter = AgendaAdapter {
        it.idContacto
        it.contacto
        it.telefono
        it.email
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idContact = it.getString("idContacto")
            nameContact = it.getString("name")
            tlfContact = it.getString("tlf")
            emailContact = it.getString("email")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailContactBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtDetailName.text = args.name
        binding.txtEmail.text = args.email
        binding.txtTelefono.text = args.telf

        binding.btnBorrarContacto.setOnClickListener{

            //FALTA IMPLEMENTAR EL BORRADO DE USUARIO.


//            NetworkConfig.service
//                .deleteContacto(args.idContacto)
//                .enqueue(object : Callback<Void> {
//                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                        if (response.isSuccessful) {
//                            Toast.makeText(context,"Deleted contact", Toast.LENGTH_SHORT).show()
//                        }else{
//                            Toast.makeText(context,"Can't delete contact. Please try again.",
//                                Toast.LENGTH_SHORT).show()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<Void>, t: Throwable) {
//                        Toast.makeText(context,"Error deleting message",Toast.LENGTH_SHORT).show()
//                    }
//
//                })
        }

    }
}

