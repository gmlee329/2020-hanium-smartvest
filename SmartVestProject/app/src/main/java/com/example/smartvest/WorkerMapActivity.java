package com.example.smartvest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class WorkerMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageView back_location_worker;
    BroadcastReceiver safety_receiver = null;
    Marker my_marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_worker);
        back_location_worker = findViewById(R.id.back_location_worker);
        back_location_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_worker);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ULSAN = new LatLng(35.50, 129.37);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(0, 0));
        markerOptions.title("작업자1");
        markerOptions.snippet("상태 : 안전");

        my_marker = mMap.addMarker(markerOptions);
        my_marker.showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ULSAN, 16));
        register_receiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister_receiver();
    }

    public void register_receiver() {
        if (safety_receiver != null)
            return;
        IntentFilter filter = new IntentFilter();
        filter.addAction("worker_safety");

        this.safety_receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                double l1 = intent.getDoubleExtra("l1", 0);
                double l2 = intent.getDoubleExtra("l2", 0);
                if (intent.getAction().equals("worker_safety")) {
                    LatLng p = new LatLng(l1, l2);
                    my_marker.setPosition(p);
                }
            }
        };

        this.registerReceiver(this.safety_receiver, filter);
    }

    public void unregister_receiver() {
        if (safety_receiver != null) {
            this.unregisterReceiver(safety_receiver);
            safety_receiver = null;
        }
    }
}
