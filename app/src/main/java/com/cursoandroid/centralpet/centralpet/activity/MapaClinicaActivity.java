package com.cursoandroid.centralpet.centralpet.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapaClinicaActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private static final LatLng mundoDosBichos = new LatLng(-7.198299, -48.216621);
    private static final LatLng arcaDaSaude = new LatLng(-7.200858, -48.202671);
   /* private static final LatLng snoopy = new LatLng(-7.192219, -48.208965);
    private static final LatLng shopDog = new LatLng(-7.188515, -48.218492);
    private static final LatLng dogCia = new LatLng(-7.186726, -48.217505);
    private static final LatLng dogShow = new LatLng(-7.192063, -48.217630);
    */
    private GoogleMap mMap;


    private Marker mMundoDosBichos;
    private Marker mArcaDaSaude;
   /* private Marker mSnoopy;
    private Marker mShopDog;
    private Marker mDogCia;
    private Marker mDogShow;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_clinica);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMinZoomPreference(13.0f);
        mMap.setMaxZoomPreference(19.0f);
        //mundo dos bichos
        mMundoDosBichos = mMap.addMarker(new MarkerOptions()
                .position(mundoDosBichos)
                .title("Mundo dos Bichos")
                .snippet("Clínica Veterinária e Pet Shop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMundoDosBichos.setTag(0);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mundoDosBichos));

        //arca da saúde
        mArcaDaSaude = mMap.addMarker(new MarkerOptions()
                .position(arcaDaSaude)
                .title("Arca da Saude")
                .snippet("Clínica Veterinária e Pet Shop")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mArcaDaSaude.setTag(0);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arcaDaSaude));

        mMap.setOnMarkerClickListener(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Integer clickCount = (Integer) marker.getTag();

        if (clickCount != null) {
            Toast.makeText(this, " Visite nosso parceiro ", Toast.LENGTH_SHORT).show();
        }

        return false;
    }

}
