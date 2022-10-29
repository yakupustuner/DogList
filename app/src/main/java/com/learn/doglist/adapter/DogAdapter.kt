package com.learn.doglist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.learn.doglist.R
import com.learn.doglist.databinding.RecyclerRowBinding
import javax.inject.Inject

class DogAdapter @Inject constructor(
    val glide:RequestManager,
    var images:List<String>
): RecyclerView.Adapter<DogAdapter.DogViewHolder>(){
    class DogViewHolder( val b: RecyclerRowBinding) : RecyclerView.ViewHolder(b.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }






    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val image = holder.itemView.findViewById<ImageView>(R.id.imageView)
        val id = images[position]
        holder.itemView.apply {
            glide.load(id).into(image)

        }
    }


    override fun getItemCount(): Int {
        return images.size
    }


}