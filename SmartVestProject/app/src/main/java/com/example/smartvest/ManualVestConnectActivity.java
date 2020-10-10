package com.example.smartvest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ManualVestConnectActivity extends AppCompatActivity {
    ImageView back_manual_vest_connect;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_vest_connect);
        back_manual_vest_connect = findViewById(R.id.back_manual_vest_connect);
        back_manual_vest_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
