package com.example.smartvest;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class WokerMainActivity extends AppCompatActivity {
    ConstraintLayout location_worker;
    ConstraintLayout safety_worker;
    ConstraintLayout manual_worker;
    ConstraintLayout report_worker;
    TextView logout_worker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_worker);
        location_worker = findViewById(R.id.location_worker);
        safety_worker = findViewById(R.id.safety_worker);
        manual_worker = findViewById(R.id.manual_worker);
        report_worker = findViewById(R.id.report_worker);
        logout_worker = findViewById(R.id.logout_worker);

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

        Intent intent = new Intent(getApplicationContext(), SafetyService.class);
        startService(intent);
    }
}
