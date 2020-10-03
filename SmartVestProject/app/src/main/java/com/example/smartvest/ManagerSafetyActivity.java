package com.example.smartvest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ManagerSafetyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ManagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_manager);

        recyclerView = findViewById(R.id.recyclerView_manager);
        adapter = new ManagerAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        query();
    }
    public void query() {
        ArrayList<Worker> items = new ArrayList<Worker>();
        for (int i = 0; i < 20; i++) {

            Worker worker = new Worker();
            worker.number = i;
            worker.danger = "위험도 낮음";
            worker.safety = "안전";
            items.add(worker);
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
