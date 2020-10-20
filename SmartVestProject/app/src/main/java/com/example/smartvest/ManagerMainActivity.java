package com.example.smartvest;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ManagerMainActivity extends AppCompatActivity {
    ConstraintLayout location_mgr;
    ConstraintLayout safety_mgr;
    TextView logout_mgr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manager);
        location_mgr = findViewById(R.id.location_mgr);
        safety_mgr = findViewById(R.id.safety_mgr);
        logout_mgr = findViewById(R.id.logout_mgr);

        location_mgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManagerMapActivity.class);
                startActivity(intent);
            }
        });
        safety_mgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManagerSafetyActivity.class);
                startActivity(intent);
            }
        });
        logout_mgr.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        logout_mgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
