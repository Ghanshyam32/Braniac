package com.ghanshyam.brainiac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getStarted: LinearLayout = findViewById(R.id.newUser);
        val loginBtn: LinearLayout = findViewById(R.id.oldUser);

        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            Toast.makeText(this, "User is already logged in", Toast.LENGTH_SHORT).show()
            redirect("LAUNCHER")
        }

        getStarted.setOnClickListener() {
            redirect("SIGNUP")
        }
        loginBtn.setOnClickListener() {
            redirect("LOGIN")
        }
    }

    private fun redirect(name: String) {
        val intent = when (name) {
            "LOGIN" -> Intent(this, Login::class.java)
            "SIGNUP" -> Intent(this, SignUp::class.java)
            "LAUNCHER" -> Intent(this, LauncherActivity::class.java)
            else ->
                throw Exception("no path exists")
        }
        startActivity(intent)
        finish()
    }

}