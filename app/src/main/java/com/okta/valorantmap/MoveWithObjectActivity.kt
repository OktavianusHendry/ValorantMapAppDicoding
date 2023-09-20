package com.okta.valorantmap

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MAP = "extra_map"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvMapName:TextView = findViewById(R.id.tv_map_name)
        val tvMapDesc:TextView = findViewById(R.id.tv_map_description)
        val imgMapPhoto:ImageView = findViewById(R.id.img_map_photo)
        val tvMapLocation:TextView = findViewById(R.id.tv_map_location)
        val tvMapCoordinate:TextView = findViewById(R.id.tv_map_coordinate)
        val tvMapSite:TextView = findViewById(R.id.tv_map_site)
        val tvMapFeature:TextView = findViewById(R.id.tv_map_feature)
        val tvMapAdded:TextView = findViewById(R.id.tv_map_added)
        val tvMapRotation:TextView = findViewById(R.id.tv_map_rotation)
        val tvMapCodename:TextView = findViewById(R.id.tv_map_codename)
        val imgMapMini:ImageView = findViewById(R.id.img_map_mini)

        val dataMap = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Maps>(EXTRA_MAP, Maps::class.java)
        } else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Maps>(EXTRA_MAP)
        }

        if (dataMap != null){
            tvMapName.text = dataMap.name
            imgMapPhoto.setImageResource(dataMap.photo)
            tvMapDesc.text = dataMap.description
            tvMapLocation.text = dataMap.location
            tvMapCoordinate.text = dataMap.coordinate
            tvMapSite.text = dataMap.site
            tvMapFeature.text = dataMap.mapFeature
            tvMapAdded.text = dataMap.added
            tvMapRotation.text = dataMap.rotation
            tvMapCodename.text = dataMap.codename
            imgMapMini.setImageResource(dataMap.minimap)
        }

        val shareButton = findViewById<Button>(R.id.action_share)

        shareButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val shareText = "Check this out! ${dataMap?.name} map from VALORANT"
            intent.putExtra(Intent.EXTRA_TEXT, shareText)

            val chooser = Intent.createChooser(intent, "Share via")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }
    }
}

