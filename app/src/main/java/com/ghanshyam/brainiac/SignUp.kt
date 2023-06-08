package com.ghanshyam.brainiac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        firebaseAuth = FirebaseAuth.getInstance();
        val createBtn: LinearLayout = findViewById(R.id.newUser);
        createBtn.setOnClickListener() {
            signUpUser();


        }
        val signInBtn: TextView = findViewById(R.id.signInActivity)
        signInBtn.setOnClickListener() {
            val i: Intent = Intent(this, Login::class.java)
            startActivity(i)
        }
    }

    private fun signUpUser() {
        val Temail: EditText = findViewById(R.id.signUp_email);
        val Tpassword: EditText = findViewById(R.id.signUp_password);
        val TconfirmPassword: EditText = findViewById(R.id.confirm_password);

//        createBtn.setOnClickListener() {

        val email: String = Temail.text.toString();
        val password: String = Tpassword.text.toString();
        val confirmPassword: String = TconfirmPassword.text.toString();


        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password != confirmPassword) {
            Toast.makeText(this, "password and confirm password doesn't match", Toast.LENGTH_SHORT)
                .show();
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                    val i: Intent = Intent(applicationContext, LauncherActivity::class.java);
                    startActivity(i);
                    finish()

                } else {
                    Toast.makeText(this, "Error creating user.", Toast.LENGTH_SHORT).show();
                }
            }


    }
}