package com.example.smartvest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ManagerMapActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageView back_location_mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manager);
        back_location_mgr = findViewById(R.id.back_location_mgr);
        back_location_mgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_manager);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ULSAN = new LatLng(35.50, 129.37);
        LatLng worker1 = new LatLng(35.501, 129.371);
        LatLng worker2 = new LatLng(35.502, 129.369);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(ULSAN);
        markerOptions.title("작업자1");
        markerOptions.snippet("상태 : 안전");
        mMap.addMarker(markerOptions).showInfoWindow();

        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(worker1);
        markerOptions1.title("작업자2");
        markerOptions1.snippet("위험도 : 안전");
        mMap.addMarker(markerOptions1);

        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(worker2);
        markerOptions2.title("작업자3");
        markerOptions2.snippet("위험도 : 안전");
        mMap.addMarker(markerOptions2);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ULSAN, 16));
    }

}
