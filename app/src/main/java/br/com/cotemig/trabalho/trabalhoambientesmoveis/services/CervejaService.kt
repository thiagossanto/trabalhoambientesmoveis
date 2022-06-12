package br.com.cotemig.trabalho.trabalhoambientesmoveis.services

import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Cerveja
import retrofit2.Call
import retrofit2.http.GET

interface CervejaService {

    @GET("cerveja")
    fun getCerveja(): Call<List<Cerveja>>

}