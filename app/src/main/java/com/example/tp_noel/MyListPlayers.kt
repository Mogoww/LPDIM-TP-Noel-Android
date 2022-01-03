package com.example.tp_noel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListPlayers(var mCtx: WaitingActivity, var ressource:Int, var items:List<Model>)
    :ArrayAdapter<Model>(mCtx,ressource,items){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
            val view:View = layoutInflater.inflate(ressource, null)

            val imageView:ImageView = view.findViewById(R.id.icon_image_view)
            val textView:TextView = view.findViewById(R.id.title_text_view)
            val textView1:TextView = view.findViewById(R.id.status_view)

            var mItems:Model = items[position]

            imageView.setImageDrawable(mCtx.resources.getDrawable(mItems.photo))
            textView.text = mItems.pseudo
            textView1.text = mItems.status

            return view
        }
    }