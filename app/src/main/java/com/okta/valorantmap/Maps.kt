package com.okta.valorantmap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Maps(
    val name: String,
    val description: String,
    val photo: Int,
    val location: String,
    val coordinate: String,
    val site: String,
    val mapFeature: String,
    val added: String,
    val rotation: String,
    val codename: String,
    val minimap: Int

) : Parcelable
