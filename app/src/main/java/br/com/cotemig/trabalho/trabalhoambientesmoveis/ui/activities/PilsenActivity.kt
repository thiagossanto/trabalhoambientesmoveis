package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Account
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Cerveja
import br.com.cotemig.trabalho.trabalhoambientesmoveis.services.RetrofitInitializer
import br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.adapters.ListaAmberAdapter
import br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.adapters.ListaPilsenAdapter
import retrofit2.Call
import retrofit2.Response

class PilsenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilsen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var backIcon = findViewById<ImageButton>(R.id.backIcon)
        backIcon.setOnClickListener {
            startInitial(Account())
        }

        getCerveja()


//        var listPilsen = findViewById<ListView>(R.id.listPilsen)
//        listPilsen.adapter = ListaPilsenAdapter(this, lista)
//
//        listPilsen.setOnItemClickListener { adapterView, view, i, l ->
//
//            var intent = Intent(this, DetalheActivity::class.java)
//            intent.putExtra("time", lista[i])
//            startActivity(intent)
//
//        }

    }

    fun startInitial(account: Account){

        var intent = Intent(this, InitialActivity::class.java)
        intent.putExtra("account", account)
        startActivity(intent)

    }

    fun getCerveja(){

        var s = RetrofitInitializer().getCervejaService()
        var call = s.getPilsen()

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

        var cerveja = findViewById<ListView>(R.id.listPilsen)
        cerveja.adapter = ListaAmberAdapter(this, list)

    }

}