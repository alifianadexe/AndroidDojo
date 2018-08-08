package com.alifianadexe.androidtrainingdojo;

/**
 * Created by ditya on 8/6/18.
 */

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private static final String TAG = MapsActivity.class.getSimpleName();
    private GoogleMap mMap;
    private CameraPosition mCameraPosition;

    // the entry points to the places API
    private GeoDataClient mGeoDataClient;
    private PlaceDetectionClient mPlaceDetectionClient;

    // the entry point
    private FusedLocationProviderClient mFusedLocationProviderClient;

    // a default location
    private final LatLng mDefaultLocation = new LatLng(-33,151);
    private static final int DEFAULT_ZOOM = 15;
    private static final int PERMISSION_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean mLocationPermissionGranted;

    // location retrivied by the Fused location provider;
    private Location mLastKnownLocation;

    // keys for Storing acivity state;
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";

    // used for selecting the current process
    private static final int M_MAX_ENTRIES = 5;
    private String[] mLikePlaceNames;
    private String[] mLikelyPlaceAddresses;
    private String[] mLikelyPlaceAttributions;
    private LatLng[] mLikelyPlaceLatLngs;



    @Override
    protected void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);

        // retrieve location and camera position from saved
        if(savedInstancestate != null){
            mLastKnownLocation = savedInstancestate.getParcelable(KEY_LOCATION);
            mCameraPosition  = savedInstancestate.getParcelable(KEY_CAMERA_POSITION);
        }

        // set layout
        setContentView(R.layout.maps_layout);

        // construct a geoDataClient
        mGeoDataClient = Places.getGeoDataClient(this,null);

        // construct a PlaceDetectionClient
        mPlaceDetectionClient = Places.getPlaceDetectionClient(this,null);

        // construct a FusedLocationProviderClient
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        // Build map'
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_layout);
        mapFragment.getMapAsync(this);
    }

    /*
     * Saves the state when paused
     */

    @Override
    protected void onSaveInstanceState(Bundle outState){
        if(mMap != null){
            outState.putParcelable(KEY_CAMERA_POSITION, mMap.getCameraPosition());
            outState.putParcelable(KEY_LOCATION, mLastKnownLocation);
        }
    }

    /*
     * Sets up the option menu
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_drawer,menu);
        return true;
    }

    /*
     * Manipulate the map when it's available
     * this callback is triggered when the map is ready to used
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
            // Inflate the layouts for the windows , title and snippet
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_contents);


                return null;
            }
        });
    }

}
