package com.example.smartvest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

    BroadcastReceiver safety_receiver = null;

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
        register_receiver();

        set_graph(graph_temp);
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

    public void set_graph(CircleProgressBar graph) {
        CircleProgressBar.ProgressFormatter progressFormatter = new CircleProgressBar.ProgressFormatter() {
            @Override
            public CharSequence format(int progress, int max) {
                return "좋음";
            }
        };
        graph.setProgressFormatter(progressFormatter);
        graph.setProgressTextColor(ContextCompat.getColor(this, R.color.button_color));
        graph.setProgressBackgroundColor(ContextCompat.getColor(this, R.color.white_gray_color));
        graph.setProgressStartColor(ContextCompat.getColor(this, R.color.button_color));
        graph.setProgressEndColor(ContextCompat.getColor(this, R.color.button_color));
        int max = 100;
        int progress = 70;
        int pi = 360;
        int start = 270;
        int degree = start-(int)((progress/(double)max)*pi);
        graph.setMax(max);
        graph.setStartDegree(degree);
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
                    int max = 100;
                    int progress = data;
                    int pi = 360;
                    int start = 270;
                    int degree = start-(int)((progress/(double)max)*pi);
                    graph_temp.setProgress(progress);
                    graph_temp.setStartDegree(degree);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister_receiver();
    }
}
