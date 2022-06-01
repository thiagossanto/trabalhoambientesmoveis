package br.com.cotemig.trabalho.trabalhoambientesmoveis.services

import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Menu
import retrofit2.Call
import retrofit2.http.GET

interface ServiceMenu{

    @GET("2397cd8d-8c32-464a-adb0-075dd6c75e29")
    fun getType(): Call<List<Menu>>

}