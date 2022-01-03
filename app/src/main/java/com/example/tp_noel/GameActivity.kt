package com.example.tp_noel

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class GameActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)



/*
        lateinit var grid : GridView
        grid = findViewById(R.id.test)
        var list = mutableListOf<ModelCmd>()
        list.add(ModelCmd("testeee",true ))
        list.add(ModelCmd("44444",true ))
        list.add(ModelCmd("333333",false ))
        grid.adapter = CmdGame(this,R.layout.button_game_layout ,list)
*/




        var por:Float
        val progressBar_game = findViewById(R.id.progressBar_game) as ProgressBar

        val timer = object: CountDownTimer(10000, 1) {
            override fun onTick(millisUntilFinished: Long) {
                var fini = 10000 - millisUntilFinished.toFloat()
                por = ((fini/10000)*100)
                progressBar_game.progress = Math.ceil(por.toDouble()).toInt()

            }

            override fun onFinish() {
                gameover()
            }
        }
        timer.start()

        for (i in 1..4) {
            val id = resources.getIdentifier("choice_$i", "id", packageName)

            findViewById<Button>(id).setOnClickListener {
                timer.cancel()
                if(findViewById<Button>(id).getText().toString() == "DEGAZER"){
                    gameWin()
                }else{
                    gameover()
                }

            }
        }

    }

   fun gameover(){
       val gameOver = Intent(this, GameOverActivity::class.java)
       gameOver.putExtra("Pseudo", intent.getStringExtra("Pseudo"))
       startActivity(gameOver)
    }
    fun gameWin(){
        val gameWin = Intent(this, GameWinActivity::class.java)
        gameWin.putExtra("Pseudo", intent.getStringExtra("Pseudo"))
        startActivity(gameWin)
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