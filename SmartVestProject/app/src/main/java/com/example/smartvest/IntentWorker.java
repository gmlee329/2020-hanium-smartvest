package com.example.smartvest;

import android.content.Intent;

public class IntentWorker {
    public static final String WORKER_ID = "worker_id";
    public static final String VEST_ID = "vest_id";
    public static final String DIRECTOR_ID = "director_id";
    public static final String FIELD_ID = "field_id";
    public static final String WARNING_SIGNAL = "warning_signal";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    public static final String TEMPERATURE = "temperature";
    public static final String HUMIDITY = "humidity";

    public static Intent makeIntent(Worker worker, String action) {
        Intent intent = new Intent(action);
        intent.setPackage("com.example.smartvest");
        intent.putExtra(WORKER_ID, worker.worker_id);
        intent.putExtra(VEST_ID, worker.vest_id);
        intent.putExtra(DIRECTOR_ID, worker.director_id);
        intent.putExtra(FIELD_ID, worker.field_id);
        intent.putExtra(WARNING_SIGNAL, worker.warning_signal);
        intent.putExtra(LATITUDE, worker.latitude);
        intent.putExtra(LONGITUDE, worker.longitude);

        intent.putExtra(TEMPERATURE, worker.temperature);
        intent.putExtra(HUMIDITY, worker.humidity);

        return intent;
    }
}
