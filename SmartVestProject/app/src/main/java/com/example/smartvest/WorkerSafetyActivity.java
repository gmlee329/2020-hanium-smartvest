package com.example.smartvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

public class WorkerSafetyActivity extends AppCompatActivity {
    ImageView back_safety_worker;
    ConstraintLayout safety_mq5;
    TextView text_safety_mq5;
    ImageView safety_mq5_info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_worker);
        safety_mq5 = findViewById(R.id.safety_mq5);
        text_safety_mq5 = findViewById(R.id.text_safety_mq5);
        safety_mq5_info = findViewById(R.id.safety_mq5_info);
        back_safety_worker = findViewById(R.id.back_safety_worker);
        back_safety_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        safety_mq5_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp(text_safety_mq5, R.raw.safety_mq5_info);
            }
        });
    }

    private void popUp(TextView textView, int resId) {
        String title = textView.getText().toString();
        String content = new MyTextReader().readTextFile(getApplicationContext(), resId);
        Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        startActivityForResult(intent, 1);
    }
}
