package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Account
import br.com.cotemig.trabalho.trabalhoambientesmoveis.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class ForgotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var backIcon = findViewById<ImageButton>(R.id.backIcon)
        backIcon.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        var btnForgot = findViewById<Button>(R.id.btnForgot)
        btnForgot.setOnClickListener {
            forgotClick()
        }

    }

    fun forgotClick(){

        var email = findViewById<EditText>(R.id.email)

        var account = Account()
        account.email = email.text.toString()

        var s = RetrofitInitializer().ServiceAccount()
        var call = s.forgot(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if(response.code() == 204){

                    Toast.makeText(this@ForgotActivity, "Verifique seu E-mail!", Toast.LENGTH_LONG).show()

                    showHome()
                }

            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@ForgotActivity, "Algo está errado...", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showHome() {

        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()

    }

}