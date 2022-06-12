package br.com.cotemig.trabalho.trabalhoambientesmoveis.services

import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Cerveja
import retrofit2.Call
import retrofit2.http.GET

interface CervejaService {

    @GET("77d12f18-a8de-4530-8083-4c9f0619a2ac")
    fun getAmber(): Call<List<Cerveja>>

    @GET("1d93d005-f21e-4bd4-a22d-d94bee863e80")
    fun getIpa(): Call<List<Cerveja>>

    @GET("3269739b-8b6e-42e9-bb1e-9fde669c83bf")
    fun getLager(): Call<List<Cerveja>>

    @GET("6fbd0677-18b5-4497-840d-6983c923c492")
    fun getPilsen(): Call<List<Cerveja>>

    @GET("b204f5ed-c66c-4036-9731-92772c2d4839")
    fun getPuroMalte(): Call<List<Cerveja>>
}