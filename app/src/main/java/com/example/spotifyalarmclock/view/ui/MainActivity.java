 package com.example.spotifyalarmclock.view.ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.spotifyalarmclock.R;
import com.example.spotifyalarmclock.viewmodel.SpotifyViewModel;


 public class MainActivity extends AppCompatActivity {

    private SpotifyViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
