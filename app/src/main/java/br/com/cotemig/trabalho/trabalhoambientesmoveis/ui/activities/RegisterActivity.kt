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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

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

        var btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            registerClick()
        }

    }

    fun registerClick(){

        var name = findViewById<EditText>(R.id.name)
        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.password)

        var account = Account()
        account.name = name.text.toString()
        account.email = email.text.toString()
        account.password = password.text.toString()

        var s = RetrofitInitializer().ServiceAccount()
        var call = s.create(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if(response.code() == 200){

                    Toast.makeText(this@RegisterActivity, "Conta Criada com Sucesso!", Toast.LENGTH_LONG).show()

                    showHome()
                }

            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Algo está errado...", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun showHome() {

        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()

    }

}