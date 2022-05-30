package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Account
import br.com.cotemig.trabalho.trabalhoambientesmoveis.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            login()
        }

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

    fun login(){

        var s = RetrofitInitializer().ServiceAccount()

        var account = Account()
        var email = findViewById<EditText>(R.id.email)
        var password = findViewById<EditText>(R.id.password)
        account.email = email.text.toString()
        account.password = password.text.toString()

        var call = s.auth(account)

        call.enqueue(object : retrofit2.Callback<Account>{
            override fun onResponse(call: Call<Account>, response: Response<Account>) {

                if(response.code() == 200){

                    response.body()?.let {
                        startInitial(it)
                    }

                } else {

                    Toast.makeText(this@HomeActivity, "Usuário ou Senha Inválidos", Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<Account>, t: Throwable) {

                Toast.makeText(this@HomeActivity, "Algo está errado...", Toast.LENGTH_LONG).show()

            }
        })

    }

    fun startInitial(account: Account){

        var intent = Intent(this, InitialActivity::class.java)
        intent.putExtra("token", account.token)
        startActivity(intent)

    }

}