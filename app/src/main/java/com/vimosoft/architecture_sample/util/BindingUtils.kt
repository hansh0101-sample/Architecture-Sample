package com.vimosoft.architecture_sample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingUtils {
    @BindingAdapter("imageSrc")
    @JvmStatic
    fun loadImage(imageView: ImageView, resId: Int) {
        imageView.setImageResource(resId)
    }
}