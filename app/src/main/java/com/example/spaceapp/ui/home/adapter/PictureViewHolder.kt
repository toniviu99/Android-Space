package com.example.spaceapp.ui.home.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.databinding.ItemPictureBinding
import com.example.spaceapp.domain.model.PictureModelItem
import com.squareup.picasso.Picasso

class PictureViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemPictureBinding.bind(view)

    fun render(pictureModelItem: PictureModelItem){
        binding.tvTitle.text = pictureModelItem.title
        binding.tvCopyright.text = pictureModelItem.copyright
        binding.tvDate.text = pictureModelItem.date
        Picasso.get().load(pictureModelItem.imageUrl).into(binding.ivPicture)
    }
}