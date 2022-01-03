package com.example.tp_noel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var name_input = findViewById(R.id.edit_name_player) as EditText
        var pseudo = ""
        var valid_name = findViewById(R.id.valid_name) as Button

        if(intent.getStringExtra("Pseudo") != null){
            name_input.setText(intent.getStringExtra("Pseudo"))
            pseudo = intent.getStringExtra("Pseudo").toString()
            valid_name.setEnabled(true)
        }


        name_input.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                if (s.toString().trim({ it <= ' ' }).isEmpty())
                {
                    valid_name.setEnabled(false)
                }
                else
                {
                    valid_name.setEnabled(true)
                    pseudo = name_input.text.toString()
                }
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
                // TODO Auto-generated method stub
            }
            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        })

        valid_name.setOnClickListener {
            //Intent pour ouvrir l'activité suivante
            val intent = Intent(this, WaitingActivity::class.java)
            // Passe le pseudo
            intent.putExtra("Pseudo", pseudo)
            ///Lancement de l'intent (changement d'écran)
            startActivity(intent)
        }
    }








    override fun onStart() {
        super.onStart()
        Log.i("TitleFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TitleFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TitleFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TitleFragment", "onStop called")
    }













}