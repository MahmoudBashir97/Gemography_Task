package com.mahmoudbashir.gemographytask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudbashir.gemographytask.R
import com.mahmoudbashir.gemographytask.pojo.Item
import com.squareup.picasso.Picasso

class Tadapter(private val mlist:ArrayList<Item>): RecyclerView.Adapter<Tadapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_title = itemView.findViewById<TextView>(R.id.txt_title)
        var txt_subtitle = itemView.findViewById<TextView>(R.id.txt_subtitle)
        var txt_desc = itemView.findViewById<TextView>(R.id.txt_desc)
        var img_avatar = itemView.findViewById<ImageView>(R.id.img_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(parent.context).inflate(R.layout.single_item_repository,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_title.text = mlist[position].name// set Title name
        holder.txt_subtitle.text = mlist[position].name // setSubTitle with name
        // this for check first if there is a description or not
        holder.txt_desc.text = (if (mlist[position].description !=null){
            mlist[position].description // set description data
        }else{
            "Its Good Repository" // this for if desc == null then set it as replacement
        }).toString()
        // set avatar url to imageView
        Picasso.get().load(mlist[position].owner.avatar_url).placeholder(R.drawable.ic_launcher_background).into(holder.img_avatar)
    }

    override fun getItemCount(): Int = mlist.size
}