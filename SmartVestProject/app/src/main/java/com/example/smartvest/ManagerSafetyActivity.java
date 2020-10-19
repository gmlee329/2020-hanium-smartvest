package com.example.smartvest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ManagerSafetyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ManagerAdapter adapter;
    ImageView back_safety_mgr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_manager);

        back_safety_mgr = findViewById(R.id.back_safety_mgr);
        back_safety_mgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.recyclerView_manager);
        adapter = new ManagerAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    public void query() {
        ArrayList<Worker> items = new ArrayList<Worker>();
        for (int i = 0; i < 20; i++) {
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
