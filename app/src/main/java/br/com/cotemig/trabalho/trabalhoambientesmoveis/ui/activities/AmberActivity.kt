package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R

class AmberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amber)

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

    }

}