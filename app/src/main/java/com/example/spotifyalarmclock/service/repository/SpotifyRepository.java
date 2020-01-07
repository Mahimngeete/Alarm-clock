package com.example.spotifyalarmclock.service.repository;

import android.content.Context;

public class SpotifyRepository {

    private Context context;
    private SpotifyService spotifyService;

    public SpotifyRepository(Context context){
        this.context = context;
    }

    public boolean isConnectedToSpotify(){
        spotifyService = new SpotifyService(context);
        return spotifyService.isConnectedToSpotify();
    }
    public void playPlaylist(String playlistName, boolean isShuffle){
        spotifyService.playPlaylist(playlistName, isShuffle);
    }


}
