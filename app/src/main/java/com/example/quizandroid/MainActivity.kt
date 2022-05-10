package com.example.quizandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button.setOnClickListener {
            if(mail_input.text.isEmpty()){
                mail_input.error = "Mail can't be empty"
                mail_input.requestFocus()
                return@setOnClickListener
            }
            if(password_input.text.isEmpty()){
                password_input.error = "Password can't be empty"
                password_input.requestFocus()
                return@setOnClickListener
            }
            if(!mail_input.text.contains('@')){
                mail_input.error = "Mail format invalid"
                mail_input.requestFocus()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail_input.text.toString(), password_input.text.toString())
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful)
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(this, "Registration unsuccessful", Toast.LENGTH_LONG).show()
                }
        }


    }
}