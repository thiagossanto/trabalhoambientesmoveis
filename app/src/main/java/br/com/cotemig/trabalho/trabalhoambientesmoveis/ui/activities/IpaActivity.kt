package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ListView
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Cerveja
import br.com.cotemig.trabalho.trabalhoambientesmoveis.services.RetrofitInitializer
import br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.adapters.ListaAmberAdapter
import retrofit2.Call
import retrofit2.Response

class IpaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipa)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var backIcon = findViewById<ImageButton>(R.id.backIcon)
        backIcon.setOnClickListener {
            var intent = Intent(this, InitialActivity::class.java)
            startActivity(intent)
            finish()
        }

        getCerveja()

    }

    fun getCerveja(){

        var s = RetrofitInitializer().getCervejaService()
        var call = s.getIpa()

        call.enqueue(object : retrofit2.Callback<List<Cerveja>>{
            override fun onResponse(call: Call<List<Cerveja>>, response: Response<List<Cerveja>>) {

                response.body()?.let {

                    showListView(it)

                }

            }

            override fun onFailure(call: Call<List<Cerveja>>, t: Throwable) {

            }
        })

    }

    fun showListView(list: List<Cerveja>){

        var cerveja = findViewById<ListView>(R.id.listIpa)
        cerveja.adapter = ListaAmberAdapter(this, list)

    }

}