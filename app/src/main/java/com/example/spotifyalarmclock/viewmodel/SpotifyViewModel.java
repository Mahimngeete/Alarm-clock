package com.example.spotifyalarmclock.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import android.content.Context;
import androidx.annotation.NonNull;

import com.example.spotifyalarmclock.service.repository.SpotifyRepository;

public class SpotifyViewModel extends AndroidViewModel {

    private SpotifyRepository spotifyRepository;

    public SpotifyViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean isConnectedToSpotify(Context context){
        spotifyRepository = new SpotifyRepository(context);
        return spotifyRepository.isConnectedToSpotify();
    }

    public void playPlaylist(String playlistName, boolean isShuffle){
        spotifyRepository.playPlaylist(playlistName, isShuffle);
    }


}
