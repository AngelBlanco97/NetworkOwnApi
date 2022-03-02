package com.angelblanco.networkownapi.network.response

import com.angelblanco.networkownapi.model.Agenda

data class AgendaResponse(val idContacto: Int, val name: String, val tlf: String, val email:String)

fun AgendaResponse.toModel(): Agenda = Agenda(
    idContacto,
    name,
    tlf,
    email
)
//   Long greater than Int be careful
// convert Long to Int not is good idea, only for show that we can convert info with mapper
//

fun List<AgendaResponse>.toModel(): List<Agenda> = map { it.toModel() }