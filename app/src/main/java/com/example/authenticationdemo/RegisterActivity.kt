package com.example.authenticationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.register_email).text.toString().trim()
            val password = findViewById<TextInputEditText>(R.id.register_password).text.toString().trim()
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                Log.d("message","sreerag")
            }
        }
    }
}