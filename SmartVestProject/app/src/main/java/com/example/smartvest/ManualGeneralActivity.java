package com.example.smartvest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ManualGeneralActivity extends AppCompatActivity {
    ImageView back_manual_general;
    TextView textview_manual_general;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_general);
        back_manual_general = findViewById(R.id.back_manual_general);
        textview_manual_general = findViewById(R.id.textview_manual_general);

        back_manual_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String text = new MyTextReader().readTextFile(this, R.raw.manual_general);
        textview_manual_general.setText(text);
    }
}
