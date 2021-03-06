package com.aarappstudios.googlemapappfromcourse

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.aarappstudios.googlemapappfromcourse.databinding.ActivityMapsBinding
import com.aarappstudios.googlemapappfromcourse.misc.CameraAndViewport
import com.aarappstudios.googlemapappfromcourse.misc.TypeAndStyle
import com.google.android.gms.maps.model.MapStyleOptions
import java.lang.Exception

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_type_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        typeAndStyle.setMapType(item,mMap)
        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val kathmandu=LatLng(27.7172,85.3240)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap.addMarker(MarkerOptions().position(kathmandu).title("Marker in ktm"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kathmandu,15f))
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.kathmandu))

        mMap.uiSettings.apply {
            isZoomControlsEnabled=true
//            isZoomGesturesEnabled=false
//            isScrollGesturesEnabled=false

            isMyLocationButtonEnabled=true
        }

        //pading
//        mMap.setPadding(100,0,100,0)

        //style
        typeAndStyle.setMapStyle(mMap,this)
    }


    companion object {
        const val TAG="TAG"
    }
}