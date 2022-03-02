package com.angelblanco.networkownapi.network.response

import com.angelblanco.networkownapi.model.Agenda

data class AgendaResponse(val _id: String, val name: String, val tlf: String, val email:String)

fun AgendaResponse.toModel(): Agenda = Agenda(
    _id,
    name,
    tlf,
    email
)

fun List<AgendaResponse>.toModel(): List<Agenda> = map { it.toModel() }
