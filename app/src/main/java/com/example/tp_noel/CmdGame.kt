package com.example.tp_noel

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Switch


class CmdGame(var mCtx: GameActivity, var ressource:Int, var items:List<ModelCmd>)
    :ArrayAdapter<ModelCmd>(mCtx,ressource,items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(ressource, null)


        /*if(mItems.type_B === true){
            view = layoutInflater.inflate(R.layout.switch_game, null)
            val switch_game:Switch = view.findViewById(R.id.switch_game)

            switch_game.text = mItems.text
        }else{
            view = layoutInflater.inflate(R.layout.button_game, null)
            val button:Button = view.findViewById(R.id.button_game)
            button.text = mItems.text
        }*/

        val btn:Button = view.findViewById(R.id.button_game)
        var mItems:ModelCmd = items[position]
        btn.text = mItems.text
/*
      btn.setOnClickListener{
            val oui:GameActivity = GameActivity()
            oui.test()

        }*/


        return view
    }

}