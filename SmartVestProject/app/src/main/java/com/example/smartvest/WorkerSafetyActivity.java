package com.example.smartvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

public class WorkerSafetyActivity extends AppCompatActivity {
    ImageView back_safety_worker;
    ConstraintLayout safety_mq5;
    TextView text_safety_mq5;
    ImageView safety_mq5_info;
    ConstraintLayout safety_mq2;
    TextView text_safety_mq2;
    ImageView safety_mq2_info;
    ConstraintLayout safety_temp;
    TextView text_safety_temp;
    ImageView safety_temp_info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_worker);
        safety_mq5 = findViewById(R.id.safety_mq5);
        text_safety_mq5 = findViewById(R.id.text_safety_mq5);
        safety_mq5_info = findViewById(R.id.safety_mq5_info);
        safety_mq2 = findViewById(R.id.safety_mq2);
        text_safety_mq2 = findViewById(R.id.text_safety_mq2);
        safety_mq2_info = findViewById(R.id.safety_mq2_info);
        safety_temp = findViewById(R.id.safety_temp);
        text_safety_temp = findViewById(R.id.text_safety_temp);
        safety_temp_info = findViewById(R.id.safety_temp_info);

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
        safety_mq2_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp(text_safety_mq2, R.raw.safety_mq2_info);
            }
        });
        safety_temp_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp(text_safety_temp, R.raw.safety_temp_info);
            }
        });
    }

    private void popUp(TextView textView, int resId) {
        PopupFragment popupFragment = new PopupFragment();
        Bundle bundle = new Bundle();

        String title = textView.getText().toString();
        String content = new MyTextReader().readTextFile(getApplicationContext(), resId);

        bundle.putString("title", title);
        bundle.putString("content", content);
        popupFragment.setArguments(bundle);
        popupFragment.show(getSupportFragmentManager(), PopupFragment.TAG_POPUP_DIALOG);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
