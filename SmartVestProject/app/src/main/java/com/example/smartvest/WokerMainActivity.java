package com.example.smartvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class WokerMainActivity extends AppCompatActivity {
    ConstraintLayout location_worker;
    ConstraintLayout safety_worker;
    ConstraintLayout manual_worker;
    ConstraintLayout report_worker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_worker);
        location_worker = findViewById(R.id.location_worker);
        safety_worker = findViewById(R.id.safety_worker);
        manual_worker = findViewById(R.id.manual_worker);
        report_worker = findViewById(R.id.report_worker);

        location_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WorkerMapActivity.class);
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
    }
}
