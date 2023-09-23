package com.rootcode.storisapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class storyAdapter(private val storylist:List<storyModel>,private val clickListener:(storyModel)->Unit):RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val storyItem = layoutInflater.inflate(R.layout.storis_item,parent,false)
        return MyViewHolder(storyItem)
    }

    override fun getItemCount(): Int {
        return storylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = storylist[position]
        holder.bind(story,clickListener)
    }


}
class MyViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    fun bind(story: storyModel, clickListener: (storyModel) -> Unit) {
        val title = view.findViewById<TextView>(R.id.storyTitle)
        val details = view.findViewById<TextView>(R.id.storyDerails)
        val Image = view.findViewById<CircleImageView>(R.id.storyImage)

        title.text = story.title
        details.text = story.details
        Image.setImageResource(story.Image)

        view.setOnClickListener{
            clickListener(story)
        }


    }
}




