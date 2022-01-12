package com.aarappstudios.googlemapappfromcourse.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.aarappstudios.googlemapappfromcourse.MapsActivity
import com.aarappstudios.googlemapappfromcourse.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions
import java.lang.Exception

class TypeAndStyle {



    fun setMapStyle(map: GoogleMap, context: Context)
    {
        try {
            val success=map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                context,
                R.raw.style
            ))
            if (!success)
                Log.d(MapsActivity.TAG, "setMapStyle: failed")
        }catch (e: Exception)
        {
            Log.d(MapsActivity.TAG, "setMapStyle: ${e.localizedMessage}")
        }
    }


    fun setMapType(item:MenuItem,mMap:GoogleMap)
    {
        when(item.itemId)
        {
            R.id.menu_normal->{
                mMap.mapType=GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.menu_hybrid->{
                mMap.mapType=GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.menu_satellite->{
                mMap.mapType=GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.menu_terrain->{
                mMap.mapType=GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.menu_none->{
                mMap.mapType=GoogleMap.MAP_TYPE_NONE
            }
        }
    }
}