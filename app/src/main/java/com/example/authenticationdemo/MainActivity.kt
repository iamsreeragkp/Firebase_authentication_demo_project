package com.example.authenticationdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val logInButton = findViewById<Button>(R.id.login_button)
        logInButton.setOnClickListener {

            val email = findViewById<TextInputEditText>(R.id.enter_email).text.toString()
            val password = findViewById<TextInputEditText>(R.id.enter_password).text.toString()

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(){ task ->
                if(task.isSuccessful){
                    val intent= Intent(this,SuccessfullLogin::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener {
                Log.d("message","failure")
                Toast.makeText(this,"failed to log in",Toast.LENGTH_SHORT).show()
            }
        }


        val signUpButton = findViewById<TextView>(R.id.signup_button)
        signUpButton.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}