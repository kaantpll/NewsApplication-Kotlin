package com.example.newsapplication.ui.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapplication.R

fun ImageView.dowloadFormUrl(url : String?,progressDrawable: CircularProgressDrawable){
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_launcher_background)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}


fun placeHolderProgressBar(context: Context): CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

@BindingAdapter("android:donwloadUrl")
fun downloadImage(view : ImageView,url : String?){
    view.dowloadFormUrl(url, placeHolderProgressBar(view.context))
}