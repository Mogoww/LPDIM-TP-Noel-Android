package com.example.tp_noel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GameWinActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        val pseudo = intent.getStringExtra("Pseudo")


        findViewById<Button>(R.id.retry_win).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("Pseudo", pseudo)
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