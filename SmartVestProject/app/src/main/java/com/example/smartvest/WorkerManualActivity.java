package com.example.smartvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class WorkerManualActivity extends AppCompatActivity {
    ImageView back_manual_worker;
    ConstraintLayout manual_smartvest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_worker);
        back_manual_worker = findViewById(R.id.back_manual_worker);
        manual_smartvest = findViewById(R.id.manual_smartvest);

        back_manual_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        manual_smartvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ManualSmartVestActivity.class);
                startActivity(intent);
            }
        });
    }
}
