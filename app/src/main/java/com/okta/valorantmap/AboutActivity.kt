package com.okta.valorantmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imageView = findViewById<ImageView>(R.id.img_foto_profil)

        val requestOptions = RequestOptions()
            .transform(CircleCrop())

        Glide.with(this)
            .load(R.drawable.pas_foto)
            .apply(requestOptions)
            .into(imageView)
    }
}