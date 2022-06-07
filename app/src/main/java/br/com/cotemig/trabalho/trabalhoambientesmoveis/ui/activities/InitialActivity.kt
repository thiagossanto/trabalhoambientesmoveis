package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Account
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Menu
import br.com.cotemig.trabalho.trabalhoambientesmoveis.services.RetrofitInitializer
import br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.adapters.MenuAdapter
import retrofit2.Call
import retrofit2.Response

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)

        var account = intent.getSerializableExtra("account") as Account

        var name = findViewById<TextView>(R.id.name)
        name.text = account.name

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        getType()

    }

    fun getType(){

        var s = RetrofitInitializer().ServiceMenu()
        var call = s.getType()

        call.enqueue(object : retrofit2.Callback<List<Menu>>{
            override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {

                if(response.code() == 200){

                    response.body()?.let {
                        showListView(it)
                    }

                } else {

                    Toast.makeText(this@InitialActivity, "Algo está errado...", Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {

                Toast.makeText(this@InitialActivity, "Algo está errado...", Toast.LENGTH_LONG).show()

            }
        })

    }

    fun showListView(list: List<Menu>){

        var menu = findViewById<ListView>(R.id.listCategory)
        menu.adapter = MenuAdapter(this, list)

    }

}