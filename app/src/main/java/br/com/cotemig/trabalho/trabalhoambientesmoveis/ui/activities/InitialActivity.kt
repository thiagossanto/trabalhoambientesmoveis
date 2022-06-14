package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
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

        var btnPilsen = findViewById<Button>(R.id.btnPilsen)
        btnPilsen.setOnClickListener {
            var intent = Intent(this, PilsenActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnLager = findViewById<Button>(R.id.btnLager)
        btnLager.setOnClickListener {
            var intent = Intent(this, LagerActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnPuromalte = findViewById<Button>(R.id.btnPuromalte)
        btnPuromalte.setOnClickListener {
            var intent = Intent(this, PuroMalteActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnAmber = findViewById<Button>(R.id.btnAmber)
        btnAmber.setOnClickListener {
            var intent = Intent(this, AmberActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnIpa = findViewById<Button>(R.id.btnIpa)
        btnIpa.setOnClickListener {
            var intent = Intent(this, IpaActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnDetalhe = findViewById<Button>(R.id.btnDetalhe)
        btnDetalhe.setOnClickListener {
            var intent = Intent(this, DetalheActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}