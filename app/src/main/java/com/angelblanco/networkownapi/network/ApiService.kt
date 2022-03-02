package com.angelblanco.networkownapi.network

import retrofit2.Call
import com.angelblanco.networkownapi.network.requests.AgendaRequest
import com.angelblanco.networkownapi.network.response.AgendaResponse
import retrofit2.http.*

interface ApiService {
    @GET("contactos")
    fun getContactos(): Call<List<AgendaResponse>>

    @POST("contactos")
    fun addContacto(@Body contactoRequest: AgendaRequest):Call<Void>

    @DELETE("contactos/{idContacto}")
    fun deleteContacto(@Path("idContacto")id:String):Call<Void>
}