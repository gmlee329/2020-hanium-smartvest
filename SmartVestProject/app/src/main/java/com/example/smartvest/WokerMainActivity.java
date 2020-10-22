package com.example.smartvest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class WokerMainActivity extends AppCompatActivity {
    ConstraintLayout location_worker;
    ConstraintLayout safety_worker;
    ConstraintLayout manual_worker;
    ConstraintLayout report_worker;
    TextView logout_worker;
    LinearLayout bluetooth_connect;
    TextView vest_connection;
    TextView safety_state_worker;
    BroadcastReceiver safety_receiver= null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_worker);
        location_worker = findViewById(R.id.location_worker);
        safety_worker = findViewById(R.id.safety_worker);
        manual_worker = findViewById(R.id.manual_worker);
        report_worker = findViewById(R.id.report_worker);
        logout_worker = findViewById(R.id.logout_worker);
        bluetooth_connect = findViewById(R.id.bluetooth_connect);
        vest_connection = findViewById(R.id.vest_connection);
        safety_state_worker = findViewById(R.id.safety_state_worker);

        location_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WorkerMapActivity.class);
                startActivity(intent);
            }
        });
        safety_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WorkerSafetyActivity.class);
                startActivity(intent);
            }
        });
        manual_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WorkerManualActivity.class);
                startActivity(intent);
            }
        });
        logout_worker.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        logout_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SafetyService.class);
                stopService(intent);
            }
        });
        bluetooth_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vest_connection.setText(getString(R.string.text_vest_connection)+"연결");
            }
        });

        Intent intent = new Intent(getApplicationContext(), SafetyService.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        register_receiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
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
                int data = intent.getIntExtra("progress", 0);
                if (intent.getAction().equals("worker_safety")) {
                    if (data > 5)
                        safety_state_worker.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.button_color));
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
