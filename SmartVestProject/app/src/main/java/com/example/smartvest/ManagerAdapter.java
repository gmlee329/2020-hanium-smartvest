package com.example.smartvest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManagerAdapter extends RecyclerView.Adapter<ManagerAdapter.ViewHolder> {
    ArrayList<Worker> items;
    Context context;
    public ManagerAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<Worker>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_safety_manager, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Worker item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Worker item){
        items.add(item);
    }

    public void setItems(ArrayList<Worker> items){
        this.items = items;
    }

    public Worker getItem(int position) {
        return items.get(position);
    }

    public void clearItems() {
        this.items.clear();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View layout;
        TextView vest_number, vest_danger, vest_safety;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            layout = itemView;
            vest_number = itemView.findViewById(R.id.vest_number);
            vest_danger = itemView.findViewById(R.id.vest_danger);
            vest_safety = itemView.findViewById(R.id.vest_safety);
        }

        public void setItem(Worker item) {
            String number = Integer.toString(item.number);
            String danger = item.danger;
            String safety = item.safety;
            vest_number.setText(number);
            vest_danger.setText(danger);
            vest_safety.setText(safety);
            vest_number.setTextColor(ContextCompat.getColor(context, R.color.button_color));
        }
    }
}
