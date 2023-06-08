package com.ghanshyam.brainiac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class Login : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()


        val btn: LinearLayout = findViewById(R.id.userSignIn)
        val createAccountBtn: TextView = findViewById(R.id.createAccountBtn)

        createAccountBtn.setOnClickListener() {
            val i: Intent = Intent(this, SignUp::class.java)
            startActivity(i)
            finish()
        }


        btn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val etEmail: EditText = findViewById(R.id.login_email);
        val etPassword: EditText = findViewById(R.id.login_password);

        val email: String = etEmail.text.toString();
        val password: String = etPassword.text.toString();


        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Email/Password cannot be empty", Toast.LENGTH_SHORT)
                .show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val i: Intent = Intent(applicationContext, LauncherActivity::class.java);
                startActivity(i);
                finish()
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}