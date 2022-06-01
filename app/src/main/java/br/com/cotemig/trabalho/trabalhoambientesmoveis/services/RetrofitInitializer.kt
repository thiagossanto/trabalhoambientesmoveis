package br.com.cotemig.trabalho.trabalhoambientesmoveis.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val URLcadastro = "https://api.falaai.app/v1/"

    private val retrofit1 =
        Retrofit.Builder()
            .baseUrl(URLcadastro)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun ServiceAccount(): ServiceAccount {

        return retrofit1.create(ServiceAccount::class.java)

    }

    private val URLtypes = "https://run.mocky.io/v3/"

    private val retrofit2 =
        Retrofit.Builder()
            .baseUrl(URLtypes)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun ServiceMenu(): ServiceMenu {

        return retrofit2.create(ServiceMenu()::class.java)

    }

}