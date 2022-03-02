package com.angelblanco.networkownapi.network.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AgendaRequest(

    @SerializedName("name")
    @Expose
    val nameContacto: String,

    @SerializedName("tlf")
    @Expose
    val telfContacto: String,

    @SerializedName("email")
    @Expose
    val emailContacto: String

)