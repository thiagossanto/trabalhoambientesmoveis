package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var btnForgot = findViewById<Button>(R.id.btnForgot)
        btnForgot.setOnClickListener {
            var intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}