 package com.example.spotifyalarmclock.view.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.spotifyalarmclock.R;
import com.example.spotifyalarmclock.service.model.Alarm;
import com.example.spotifyalarmclock.view.adapter.AlarmAdapter;
import com.example.spotifyalarmclock.viewmodel.AlarmViewModel;
import com.example.spotifyalarmclock.viewmodel.SpotifyViewModel;

import java.util.List;


 public class MainActivity extends AppCompatActivity {

    private SpotifyViewModel mainActivityViewModel;
    private AlarmViewModel alarmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_alarm_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AlarmAdapter adapter = new AlarmAdapter();
        recyclerView.setAdapter(adapter);

        alarmViewModel = ViewModelProviders.of(MainActivity.this).get(AlarmViewModel.class);
        alarmViewModel.getAllAlarms().observe(this, alarms -> adapter.submitList(alarms));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityViewModel = ViewModelProviders.of(MainActivity.this).get(SpotifyViewModel.class);
        mainActivityViewModel.isConnectedToSpotify(this);

    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}
