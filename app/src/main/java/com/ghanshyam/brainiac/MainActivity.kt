package com.ghanshyam.brainiac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getStarted: LinearLayout = findViewById(R.id.newUser);
        val loginBtn: LinearLayout = findViewById(R.id.oldUser);

        getStarted.setOnClickListener() {
            val intent: Intent = Intent(applicationContext, SignUp::class.java);
            startActivity(intent);
        }
        loginBtn.setOnClickListener() {
            val intent: Intent = Intent(applicationContext, Login::class.java);
            startActivity(intent);
        }
    }
}