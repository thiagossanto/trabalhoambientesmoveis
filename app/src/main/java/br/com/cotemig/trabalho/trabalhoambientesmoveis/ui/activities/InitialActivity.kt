package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Account
import br.com.cotemig.trabalho.trabalhoambientesmoveis.services.RetrofitInitializer
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

    }

}