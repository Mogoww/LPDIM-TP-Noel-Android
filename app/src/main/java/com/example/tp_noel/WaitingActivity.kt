package com.example.tp_noel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlin.concurrent.fixedRateTimer
import kotlin.random.Random



class WaitingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiting)


        var waiting_text = findViewById(R.id.waiting_text) as TextView
        var etat_room = findViewById(R.id.etat_room) as TextView
        var socket_status = findViewById(R.id.socket_status) as RadioButton

        val pseudo = intent.getStringExtra("Pseudo")

        var listView = findViewById(R.id.listView) as ListView

        var list = mutableListOf<Model>()



        findViewById<Button>(R.id.join_room).setOnClickListener {

            waiting_text.setText("Set your status to Ready, when everyone is ready, game will start")
            socket_status.setText("Socket connected")
            etat_room.setText("testRoom")

            socket_status.setButtonTintList(ContextCompat.getColorStateList(this, R.color.green));


            val button_ready = findViewById<Button>(R.id.ready)

            button_ready.visibility = View.VISIBLE
            findViewById<Button>(R.id.join_room).visibility = View.GONE



            list.add(Model(pseudo+" (ME)",   "WAITING",   R.drawable.astronaute_1  ))
            list.add(Model("HENRI",   "WAITING",   R.drawable.astronaute_1  ))

            listView.adapter = MyListPlayers(this,R.layout.item_list_view_layout,list)




            var task =  fixedRateTimer("timer",false,2000,2000){
                this@WaitingActivity.runOnUiThread {
                    list += create_players()
                    listView.adapter = MyListPlayers(this@WaitingActivity,R.layout.item_list_view_layout,list)
                    if (list.count()>=4){
                        cancel()
                    }
                }
            }
        }





        findViewById<Button>(R.id.ready).setOnClickListener {
            //Changer status perso
            if(list[0].status == "WAITING"){
                list[0].status = "READY"
            }else{
                list[0].status = "WAITING"
            }

            listView.adapter = MyListPlayers(this@WaitingActivity,R.layout.item_list_view_layout,list)
            room_test(list, pseudo)
        }
    }


    private fun room_test(list:List<Model>, pseudo:String?){
        var ready = true
        list.forEach(){
            if(it.status != "READY" ){
            ready = false
            }
        }

        if(list.count()<=4 && list.count()>=2 && ready == true){

            //Intent pour ouvrir l'activité suivante
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("Pseudo", pseudo)
            //Lancement de l'intent (changement d'écran)
            startActivity(intent)
        }
}




    private fun create_players():List<Model>{
        //List pseudos
        var pseudos = listOf("Ajay","Vijay","Prakash","LeKiller","Meyriu","Frexs","Grimdal","Raptor","PetiteFée","Pewfan","Seltade","Kairrin","Potaaato","Neptendus","RainbowMan","Exominiate","Meyriu","Ectobiologiste","ItsGodHere","MaxMadMen","TankerTanker","Felipero","TheFlyingBat","JustEpic")
        //List images
        var list_img = listOf<Int>(R.drawable.astronaute_0,R.drawable.astronaute_1,R.drawable.astronaute_2,R.drawable.astronaute_3,R.drawable.astronaute_4,R.drawable.astronaute_5,R.drawable.astronaute_6,R.drawable.astronaute_7,R.drawable.astronaute_8)

        var listadd = mutableListOf<Model>()
        listadd.add(Model(pseudos[Random.nextInt(0, pseudos.count()-1)],   "READY",   list_img[Random.nextInt(0, list_img.count()-1)]   ))
        return listadd
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