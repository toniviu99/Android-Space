package com.example.spaceapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.R
import com.example.spaceapp.domain.model.PictureModelItem

class PictureAdapter(private var pictureList: List<PictureModelItem> = emptyList(),
    private val onItemSelected:(PictureModelItem) ->Unit):
    RecyclerView.Adapter<PictureViewHolder>() {

    fun updateList(list: List<PictureModelItem>){
        pictureList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_picture ,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pictureList.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.render(pictureList[position], onItemSelected)
    }
}