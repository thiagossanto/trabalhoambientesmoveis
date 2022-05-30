package br.com.cotemig.trabalho.trabalhoambientesmoveis.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val URL = "https://api.falaai.app/v1/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun ServiceAccount(): ServiceAccount {

        return retrofit.create(ServiceAccount::class.java)

    }

}