package com.okta.valorantmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMaps: RecyclerView
    private val list = ArrayList<Maps>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        rvMaps = findViewById(R.id.rv_maps)
        rvMaps.setHasFixedSize(true)

        list.addAll(getListMaps())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvMaps.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvMaps.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page ->{
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListMaps(): ArrayList<Maps>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataCoordinate = resources.getStringArray(R.array.data_coordinate)
        val dataSite = resources.getStringArray(R.array.data_sites)
        val dataMapFeature = resources.getStringArray(R.array.data_map_feature)
        val dataAdded = resources.getStringArray(R.array.data_added)
        val dataRotation = resources.getStringArray(R.array.data_rotation)
        val dataCodename = resources.getStringArray(R.array.data_codename)
        val dataMiniMap = resources.obtainTypedArray(R.array.data_minimap)
        val listMaps = ArrayList<Maps>()
        for (i in dataName.indices){
            val map = Maps(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataLocation[i], dataCoordinate[i], dataSite[i], dataMapFeature[i], dataAdded[i], dataRotation[i], dataCodename[i], dataMiniMap.getResourceId(i, -1))
            listMaps.add(map)
        }
        return listMaps
    }

    private fun showRecyclerList(){
        rvMaps.layoutManager = LinearLayoutManager(this)
        val listMapAdapter = ListMapAdapter(list)
        rvMaps.adapter = listMapAdapter
    }


}