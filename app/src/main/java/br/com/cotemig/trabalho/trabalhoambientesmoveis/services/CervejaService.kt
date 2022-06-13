package br.com.cotemig.trabalho.trabalhoambientesmoveis.services

import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Cerveja
import retrofit2.Call
import retrofit2.http.GET

interface CervejaService {

    @GET("edffab62-efe0-4800-b557-b702b928c98e")
    fun getAmber(): Call<List<Cerveja>>

    @GET("16be29ba-7126-4623-b9f6-d277f51b9318")
    fun getIpa(): Call<List<Cerveja>>

    @GET("2207b7cf-a062-46e3-b54f-2be2175c3b44")
    fun getLager(): Call<List<Cerveja>>

    @GET("6fbd0677-18b5-4497-840d-6983c923c492")
    fun getPilsen(): Call<List<Cerveja>>

    @GET("b204f5ed-c66c-4036-9731-92772c2d4839")
    fun getPuroMalte(): Call<List<Cerveja>>
}