package com.cursoandroid.centralpet.centralpet.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cursoandroid.centralpet.centralpet.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaClinicaActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private static final LatLng mundoDosBichos = new LatLng(-7.198299, -48.216621);

    private GoogleMap mMap;


    private Marker mMundoDosBichos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_clinica);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap map){
        mMap = map;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMinZoomPreference(11.0f);
        mMap.setMaxZoomPreference(19.0f);
    //mundo dos bichos
        mMundoDosBichos = mMap.addMarker(new MarkerOptions()
                .position(mundoDosBichos)
                .title("Mundo dos Bichos")
                .snippet("Clínica Veterinária e Pet Shop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMundoDosBichos.setTag(0);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mundoDosBichos));


        mMap.setOnMarkerClickListener(this);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Integer clickCount = (Integer) marker.getTag();

        if (clickCount != null) {
            Toast.makeText(this," Visite nosso parceiro ", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
