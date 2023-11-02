package com.example.spaceapp.ui.home.adapter

import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.databinding.ItemPictureBinding
import com.example.spaceapp.domain.model.PictureModelItem
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PictureViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemPictureBinding.bind(view)
    private var minimized = true

    fun render(pictureModelItem: PictureModelItem){
        binding.tvTitle.text = pictureModelItem.title
        binding.tvCopyright.text = pictureModelItem.copyright

        binding.tvDate.text = pictureModelItem.date
        var localDate: LocalDate = LocalDate.parse(pictureModelItem.date)
        val date = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        binding.tvDate.text = date

        Picasso.get().load(pictureModelItem.imageUrl).into(binding.ivPicture)
        arrowListener()

    }

    private fun arrowListener() {
        val params = binding.lyInfo.layoutParams
        params.height = 1
        binding.lyInfo.layoutParams = params
        binding.lyInfo.translationY = -300f

        binding.ivArrow.setOnClickListener {
            if (minimized){
                ObjectAnimator.ofFloat(binding.lyInfo,"translationY", 0f).apply {
                    duration = 150
                    start()
                }
                params.height = 0
                binding.lyInfo.layoutParams = params
                binding.ivArrow.rotation = 180f
                minimized = false
            } else{
                params.height = 1
                binding.lyInfo.layoutParams = params
                binding.lyInfo.translationY = -300f
                binding.ivArrow.rotation = 0f
                minimized = true
            }
        }
    }
}