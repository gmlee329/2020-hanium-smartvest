package com.example.smartvest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.dinuscxj.progressbar.CircleProgressBar;


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

    CircleProgressBar graph_temp;
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

        graph_temp = findViewById(R.id.graph_temp);
        CircleProgressBar.ProgressFormatter progressFormatter = new CircleProgressBar.ProgressFormatter() {
            @Override
            public CharSequence format(int progress, int max) {
                return "좋음";
            }
        };
        graph_temp.setProgressFormatter(progressFormatter);
        graph_temp.setProgressTextColor(ContextCompat.getColor(this, R.color.button_color));
        graph_temp.setProgressBackgroundColor(ContextCompat.getColor(this, R.color.white_gray_color));
        graph_temp.setProgressStartColor(ContextCompat.getColor(this, R.color.button_color));
        graph_temp.setProgressEndColor(ContextCompat.getColor(this, R.color.button_color));
        int max = 100;
        int progress = 70;
        int pi = 360;
        int start = 270;
        int degree = start-(int)((progress/(double)max)*pi);
        graph_temp.setMax(max);
        graph_temp.setProgress(progress);
        graph_temp.setStartDegree(degree);
        safety_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = 100;
                int progress = (int)(Math.random()*101);
                int pi = 360;
                int start = 270;
                int degree = start-(int)((progress/(double)max)*pi);
                graph_temp.setProgress(progress);
                graph_temp.setStartDegree(degree);
            }
        });

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
