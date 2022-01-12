package com.aarappstudios.googlemapappfromcourse.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewport
{
    val kathmandu:CameraPosition=CameraPosition.builder()
        .target(LatLng(27.7172,85.3240))
        .bearing(50f)
        .tilt(45f)
        .zoom(17f)
        .build()
}