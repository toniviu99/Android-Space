package com.example.spaceapp.ui.home.adapter

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.databinding.ItemPictureBinding
import com.example.spaceapp.domain.model.PictureModelItem
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PictureViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemPictureBinding.bind(view)
    private var minimized = true

    fun render(pictureModelItem: PictureModelItem, onItemSelected: (PictureModelItem) -> Unit){
        binding.tvTitle.text = pictureModelItem.title
        binding.tvCopyright.text = pictureModelItem.copyright

        binding.tvDate.text = pictureModelItem.date
        var localDate: LocalDate = LocalDate.parse(pictureModelItem.date)
        val date = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        binding.tvDate.text = date

        Picasso.get().load(pictureModelItem.imageUrl).into(binding.ivPicture)
        arrowListener()
        binding.btnMoreInfo.setOnClickListener {
            startRotationAnimation(binding.ivVia, newLambda = {onItemSelected(pictureModelItem)})
        }

    }

    private fun arrowListener() {
        val params = binding.lyInfo.layoutParams
        params.height = 1
        binding.lyInfo.layoutParams = params
        binding.lyInfo.translationY = -300f

        binding.lybanner.setOnClickListener {
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
    private fun startRotationAnimation(view:View, newLambda:()->Unit){
        view.animate().apply{
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{
                newLambda()
            }
            start()
        }
    }
}